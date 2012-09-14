/*
 Copyright 2007 Misko Hevery <misko@hevery.com>

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/
package com.oasis.component.cal
{
	import com.oasis.component.cal.decoration.VerticalTimeRuler;
	import com.oasis.component.cal.event.CalendarEvent;
	import com.oasis.component.cal.view.CalendarView;
	
	import mx.collections.ArrayCollection;
	import mx.containers.HBox;
	import mx.controls.VScrollBar;
	import mx.formatters.DateFormatter;

	public class WeekView extends HBox
	{
		
		protected var rulerChrome:DayChrome = new DayChrome();
		protected var ruler:VerticalTimeRuler = new VerticalTimeRuler();
		protected var scrollBar:VScrollBar = new VScrollBar();
		protected var chromes:ArrayCollection = new ArrayCollection();
		protected var views:ArrayCollection = new ArrayCollection();
		
		public var dateFormatter:DateFormatter = new DateFormatter();
		
		public var hourHeight:Number = 50;
		
		private var _use24HourClock:Boolean = false;
		
		public function get use24HourClock():Boolean { return _use24HourClock; }
		
		public function set use24HourClock(u24:Boolean):void {
			_use24HourClock = u24;
			ruler = new VerticalTimeRuler(_use24HourClock);
			ruler.pixelsPerMilisecond = hourHeight / DateUtil.HOUR;			
			invalidateDisplayList();
		}
		
		private var _calendarEventClass:Class = CalendarEvent;
		
		public function get calendarEventClass():Class {
			return _calendarEventClass;
		}
		
		public function set calendarEventClass(cev:Class):void {
			_calendarEventClass = cev;
			for each (var view:CalendarView in views) {
				view.calendarEventClass = _calendarEventClass;
			}
		}

		public function set calendarDescriptor(calendarDescriptor:CalendarDescriptor):void {
			for each (var view:CalendarView in views)
				view.calendarDescriptor = calendarDescriptor;
		}
		
		public function set events(events:ArrayCollection):void {
			for each (var view:CalendarView in views)
				view.events = events;
		}
		
		public function addEvent(event:*):void {
			for each (var view:CalendarView in views) {
				view.addEvent(event);
			}
		}
		
		public function removeEvent(event:*):void {
			for each (var view:CalendarView in views) {
				view.removeEvent(event);
			}
		}
		
		public function set calendars(calendars:ArrayCollection):void {
			for each (var view:CalendarView in views)
				view.calendars = calendars;
		}
		
		public function set date(date:Date):void {
			date = DateUtil.trimToWeek(date);
			for (var i:int = 0; i < 7 ; i++) {
				var chrome:DayChrome = chromes.getItemAt(i) as DayChrome;
				var view:CalendarView = views.getItemAt(i) as CalendarView;
				chrome.title = dateFormatter.format(date);
				view.date = date;
				
				date = new Date(date.time + DateUtil.DAY);
			}
		}
		
		public function WeekView(hrHeight:Number=50) {
			hourHeight = hrHeight;
			ruler.pixelsPerMilisecond = hourHeight / DateUtil.HOUR;
			for (var i:int = 0; i < 7 ; i++) {
				views.addItem(new CalendarView());
				chromes.addItem(new DayChrome());
			}
			dateFormatter.formatString = "EEEE MMM D";
		}
		
		override protected function createChildren():void {
			super.createChildren();
			
			rulerChrome.title = "";
			rulerChrome.percentHeight = 100;
			rulerChrome.width = 52;
			rulerChrome.verticalScrollBar = scrollBar;
			rulerChrome.addChild(ruler);
			addChild(rulerChrome);

			ruler.height = 24 * hourHeight;
			
			label = "Week";
			setStyle("horizontalGap", 0);
			
			scrollBar.percentHeight = 100;
			
			for (var i:int = 0; i < 7 ; i++) {
				var chrome:DayChrome = chromes.getItemAt(i) as DayChrome;
				chrome.percentHeight = 100;
				chrome.percentWidth = 100;
				chrome.verticalScrollBar = scrollBar;
				
				var view:CalendarView = views.getItemAt(i) as CalendarView;
				view.height = 24 * hourHeight;
				view.percentWidth = 100;
				
				chrome.addChild(view);
				addChild(chrome);
			}
			addChild(scrollBar);
//			date = new Date();
		}
		
		override protected function updateDisplayList(unscaledWidth:Number, unscaledHeight:Number):void {
			super.updateDisplayList(unscaledWidth, unscaledHeight);
			updateScrollSize();
		}
		
		private function updateScrollSize():void {
			var viewHeight:Number = chromes.getItemAt(0).viewHeight;
			var actualHeight:Number = 24 * hourHeight;
			if (actualHeight > viewHeight) {
				scrollBar.visible = true;
				scrollBar.setScrollProperties(viewHeight, 0, actualHeight - viewHeight, viewHeight);
			} else {
				scrollBar.visible = false;
			}
		}
	}
}