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
	import flash.events.Event;

	public class SelectDay extends Event
	{
		public static const SELECT_DAY:String = "selectDay";
		public var date:Date;
		
		public function SelectDay(date:Date) {
			super(SELECT_DAY);
			this.date = date;
		}
	}
}