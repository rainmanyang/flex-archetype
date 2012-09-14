package com.oasis.component.grid.footerDataGrid{
    import com.best.oasis.flexbase.util.*;
    
    import mx.controls.listClasses.IListItemRenderer;
    import mx.core.IFactory;

    public class SummaryColumn implements IFooterDataGridColumn {
        public static const SUM:String = 'sum';
        public static const MIN:String = 'min';
        public static const MAX:String = 'max';
        public static const AVG:String = 'average';
        public static const COUNT:String = 'count';
        
        private var _dataColumn:Object;
		/**
		 * 合计后的结果 
		 */
        public var summaryValue:Number;
		
        [Bindable] public var footer:SummaryFooter;
        [Bindable] public var labelFunction:Function;
        [Bindable] public var label:String;
        [Bindable] public var itemRenderer:IFactory;
        [Bindable] public var column:Object;
        [Bindable] public var renderer:IListItemRenderer;
        [Bindable] public var useColumnItemRenderer:Boolean = false;
        
        public var precision:int = 0;
        
        private var _operation:String;

        // dataColumn is the one that feeds the data
        public function set dataColumn(value:Object):void {
            _dataColumn = value;
        }

        public function get dataColumn():Object {
            return (_dataColumn) ? _dataColumn : column;
        }

        private function average(col:Object):Number {
            if (dataProvider) {
                return (sum(col) / dataProvider.length);
            } else {
                return 0;
            }
        }
        
        private function sum(col:Object):Number {
            var total:Number = 0;
			var t:Number;
            for each (var row:Object in dataProvider) {
				var value:Object = ExpressionUtils.resolveExpression(row, col.dataField);
				if (value != null) {
					t = Number(value);
					if(!isNaN(t)){
                		total += t;
					}
				}
            }
                
            return total;
        }
        
        private function min(col:Object):Number {
            var min:Number;
            for each (var row:Object in dataProvider) {      
                var value:Object = ExpressionUtils.resolveExpression(row, col.dataField);
                if (value != null) {
                    if(Number(value) < min || !min) {
                        min = Number(value);
                    }
                }
            }
                    
            return min;
        }
        
        private function max(col:Object):Number {
            var max:Number;
            for each (var row:Object in dataProvider) {
                var value:Object = ExpressionUtils.resolveExpression(row, col.dataField);
                if(value != null) {
                    if (Number(value) > max || !max) {
                        max = Number(value);
                    }
                }
            }
                    
            return max;
        }
        
        private function count(col:Object):Number {
            var count:Number;
            for each (var row:Object in dataProvider) {
                if (ExpressionUtils.resolveExpression(row, col.dataField)) {
                    count++;
                }
            }
                    
            return count;
        }
        
        public function set operation(value:String):void {
            _operation = value;
            labelFunction = defaultLabelFunction;
        }
        
        private function defaultLabelFunction(col:Object):String {
            var value:Number = 0;
            
            switch (_operation) {
                case SUM:
                    value = sum(col);
                    break;
                case AVG:
                    value = average(col);
                    break;
                case MIN:
                    value = min(col);
                    break;
                case MAX:
                    value = max(col);
                    break;
                case COUNT:
                    value = count(col);
                    break;
            }
			summaryValue = new Number(value.toFixed(precision));
            var label:String = (!isNaN(value)) ? value.toFixed(precision) : '';
            
            return label.replace(/\.00/,'');
        }
        
        public function get dataProvider():Object {
            return footer.dataProvider;
        }
    }
}