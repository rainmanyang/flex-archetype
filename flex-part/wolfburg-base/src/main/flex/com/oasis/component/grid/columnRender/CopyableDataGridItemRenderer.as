package com.oasis.component.grid.columnRender
{
	import flash.display.DisplayObject;
	import flash.geom.Point;
	import flash.geom.Rectangle;
	import flash.utils.getDefinitionByName;
	import flash.utils.getQualifiedClassName;
	import flash.utils.getQualifiedSuperclassName;
	
	import mx.controls.DataGrid;
	import mx.controls.Text;
	import mx.controls.listClasses.BaseListData;
	import mx.controls.listClasses.IDropInListItemRenderer;
	import mx.controls.listClasses.IListItemRenderer;
	import mx.core.IDataRenderer;
	import mx.core.IFlexDisplayObject;
	import mx.core.IToolTip;
	import mx.core.UIComponent;
	import mx.core.UIComponentGlobals;
	import mx.core.UITextField;
	import mx.core.mx_internal;
	import mx.events.FlexEvent;
	import mx.events.InterManagerRequest;
	import mx.events.ToolTipEvent;
	import mx.managers.ILayoutManagerClient;
	import mx.managers.ISystemManager;
	import mx.styles.CSSStyleDeclaration;
	import mx.styles.IStyleClient;
	import mx.styles.StyleManager;
	import mx.styles.StyleProtoChain;
	
	public class CopyableDataGridItemRenderer extends Text implements IDataRenderer,
		IDropInListItemRenderer, ILayoutManagerClient,
		IListItemRenderer, IStyleClient
	{
		
		//--------------------------------------------------------------------------
		//
		//  Constructor
		//
		//--------------------------------------------------------------------------
		
		/**
		 *  Constructor.
		 */
		public function CopyableDataGridItemRenderer()
		{
			super();
			
			tabEnabled = false;
			
		}
		
	}
	

}