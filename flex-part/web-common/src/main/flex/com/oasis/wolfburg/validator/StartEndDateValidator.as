package com.oasis.wolfburg.validator
{
	import com.best.oasis.flexbase.components.date.DateInput;
	
	import mx.controls.DateField;
	import mx.validators.ValidationResult;
	import mx.validators.Validator;

	public class StartEndDateValidator extends Validator 
	{
		public function StartEndDateValidator(){
			super(); 
		}
		
		private var _error:String ="结束日期必须大于开始日期"; 
		
		private var _startDate:DateField;
		
		private var _endDate:DateField;
		
		public function set startDate(value:DateField):void {
			_startDate = value;
		}
		
		public function set endDate(value:DateField):void {
			_endDate = value;
		}
		
		public function get fieldError():String  
		{  
			return _error;  
		}  
		
		public function set fieldError(value:String):void  
		{  
			_error = value;  
		}  
		
		override protected function doValidation(value:Object):Array 
		{ 
			//定义返回值，并初始化 
			var results:Array; 
			results = []; 
			var d1:Number =  Date.parse(_startDate.selectedDate);
			var d2:Number =  Date.parse(_endDate.selectedDate);
			if(d1 >= d2) {
				_endDate.errorString = _error;
				var vr:ValidationResult = new ValidationResult(true,null,"error",_error); 
				//把校验结果加入到返回值数组中。 
				results.push(vr); 
			}
			
			//返回校验结果 
			return results; 
		} 
	}
}