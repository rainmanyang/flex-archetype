package com.oasis.security
{
	import flexlib.controls.sliderClasses.ExtendedSlider;
	
	import mx.controls.Button;

	[Bindable]
	[RemoteClass(alias="com.oasis.tmsv5.common.vo.security.ButtonPremissonVO")]
	public class ButtonPremission extends Button
	{
		public function ButtonPremission(){}
		
		public var premission:Object;
		
	}
}