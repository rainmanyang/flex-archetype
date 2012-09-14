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
package com.oasis.tmsv5.view.popup.calendar
{
	import com.oasis.component.cal.CalendarDescriptor;
	import com.oasis.wolfburg.enum.EnumManage;
	

	public class TruckRsJobCalendarDescriptor implements CalendarDescriptor
	{
		public function getCalendarColor(calendar:*):Number {
			return (calendar as Calendar).color;
		}
		
		public function getCalendarName(calendar:*):String {
			return (calendar as Calendar).name;
		}
		
		public function getCalendar(event:*):* {
			return (event as TruckRSJob4Calendar).calendar;
		}

		public function getEventStart(event:*):Date {
			return (event as TruckRSJob4Calendar).startDate;
		}
		
		public function getEventEnd(event:*):Date {
			return (event as TruckRSJob4Calendar).startDate;
		}
		
		public function getEventTitle(event:*):String {
			return "title";
		}
		
		public function getEventDescription(event:*):String {
			var job:TruckRSJob4Calendar = event as TruckRSJob4Calendar;
			var license:String = job.licensePlate;
			var status:String = EnumManage.getDisplayText(job.status,EnumManage.getRSJobStatus());
			var showStr:String = (license == null ? "未派车"+" "+status:license + " "+status);
			return showStr;
		}
		
		public function getEventColor(event:*):Number {
			return (event as TruckRSJob4Calendar).calendar.color;
		}
		
		
	}
}