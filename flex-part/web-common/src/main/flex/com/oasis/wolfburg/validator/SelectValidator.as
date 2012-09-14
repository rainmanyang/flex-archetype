package com.oasis.wolfburg.validator
{
	import mx.validators.Validator;
	import mx.validators.ValidationResult;
	
	public class SelectValidator extends Validator{
		public function SelectValidator(){
			super();
		}
		
		private var error:String = "";
		
		public function set fieldError(value:String):void {
			error = value;  
		}
		
		override protected function doValidation(value:Object):Array{
			var results:Array = [];
			if(value == -1){
				var vr:ValidationResult = new ValidationResult(true,null,"error",error);
				results.push(vr);
			}
			//返回校验结果 
			return results; 
		}
	}
}