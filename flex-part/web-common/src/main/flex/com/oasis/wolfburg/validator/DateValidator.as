package com.oasis.wolfburg.validator
{
	import mx.validators.Validator;
	import mx.validators.ValidationResult; 
	
	public class DateValidator extends Validator
	{
		public function DateValidator(){
			super();
		}
		
		private var _error:String ="日期格式不正确,例2012-01-01";
		
		public function get fieldError():String{  
			return _error;  
		}  
		
		public function set fieldError(value:String):void{  
			_error = value;  
		}  
		
		override protected function doValidation(value:Object):Array{ 
			//定义返回值，并初始化 
			var results:Array; 
			results = []; 
			if(value == ""){
				return results;
			}
			//执行父类的基本数据校验 
			results = super.doValidation(value); 
			if(results.length > 0){  //如果校验未通过，则终止继续执行。 
				return results; 
			} 
			
			//如果校验通过，则执行自定义的校验功能。 
			//利用正则表达式校验：只能为英文或数字 
			var reg:RegExp = /^(19|2\d)\d{2}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$/;
			
			//校验 
			if(!reg.test(value.toString())){ 
				//如果校验未通过，则生成一个校验结果 
				var vr:ValidationResult = new ValidationResult(true,null,"error",_error); 
				//把校验结果加入到返回值数组中。 
				results.push(vr); 
			} 
			
			//返回校验结果 
			return results; 
		} 
	}
}