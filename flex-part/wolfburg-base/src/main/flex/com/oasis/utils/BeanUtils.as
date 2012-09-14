package com.oasis.utils
{
	import com.best.oasis.flexbase.lang.IEqualable;
	import com.best.oasis.flexbase.util.LangUtil;
	
	public class BeanUtils
	{
		import mx.collections.ArrayCollection;
		import flash.utils.describeType;
		import mx.utils.ObjectUtil;
		import flash.utils.getDefinitionByName;
		
		public function BeanUtils()
		{
		}
		
		private static var destProperty:Object;
		
		private static var origProperty:Object;
		
		private static var copyAbleTypes:ArrayCollection;
		
		private static function getCopyAbleTypes():ArrayCollection
		{
			var types:ArrayCollection = new ArrayCollection();
			types.addItem("int");
			types.addItem("String");
			types.addItem("Boolean");
			types.addItem("Number");
			types.addItem("Date");
			return types;
		}
		/**
		 * 把orig的所有属性复制到dest中 
		 * @param dest
		 * @param orig
		 * 
		 */
		public static function copyProperties(dest:Object, orig:Object):void
		{
			if(dest == null){
				throw new Error("dest object can't be null!");
			}
			copyAbleTypes = getCopyAbleTypes();
			if(orig is ArrayCollection){
				copyArrayCollection(ArrayCollection(dest), ArrayCollection(orig));
				return;
			}
			var properties:XMLList=describeType(orig).accessor;
			for each(var propertyInfo:XML in properties){
				var propertyType:String = propertyInfo.@type;
				var propertyName:String = propertyInfo.@name;
				var access:String = propertyInfo.@access;
				
				if (access == "readwrite" && copyAbleTypes.contains(propertyType))
				{
					
					if (dest.hasOwnProperty(propertyName))
					{
						dest[propertyName] = orig[propertyName];
					}
					
				}else if("mx.collections::ArrayCollection" == propertyType){
					var destProperty:ArrayCollection = ArrayCollection(dest[propertyName]);
					var origProperty:ArrayCollection = ArrayCollection(orig[propertyName]);
					if(origProperty == null){
						if(destProperty != null){
							destProperty.removeAll();
						}
						dest[propertyName] = null;
					}else{
						if(destProperty == null){
							destProperty = new ArrayCollection();
							dest[propertyName] = destProperty;
						}else{
							destProperty.removeAll();
						}
						for each(var o:Object in origProperty){
							destProperty.addItem(ObjectUtil.copy(o));
						}
					}
				}else{
					if (access == "readwrite"){
						if(orig[propertyName] != null){
							dest[propertyName] = ObjectUtil.copy(orig[propertyName]);
						}else{
							dest[propertyName] = null;
						}
					}
				}
			}
		}
		private static function copyArrayCollection(dest:ArrayCollection, orig:ArrayCollection):void{
			if(orig == null){
				if(dest != null){
					dest.removeAll();
				}else{
					dest = new ArrayCollection();
				}
			}else{
				if(dest == null){
					dest = new ArrayCollection();
				}else{
					dest.removeAll();
				}
				for each(var o:Object in orig){
					dest.addItem(ObjectUtil.copy(o));
				}
			}
		}
		/**
		 * 克隆一个对象，和ObjectUtil.copy相同的功能。貌似ObjectUtil.copy有bug
		 * @param o
		 * @return 
		 * 
		 */        
		public static function clone(o:Object):Object{
			var description:XML = describeType(o);
			var className:String = description.@name;
			var ClassReference:Class = getDefinitionByName(className) as Class;
			var result:Object = new ClassReference();
			copyProperties(result, o);
			return result;
		}
		
		/**
		 * 从list中删除id在ids里面的对象 
		 * @param list
		 * @param ids
		 * 
		 */
		public static function removeByIds(list:ArrayCollection, ids:ArrayCollection):void{
			var objId:Number;
			for(var i:int; i<list.length; i++){
				objId = Number(list[i]['id']);
				if(ids.contains(objId)){
					list.removeItemAt(i);
					i--;
				}
			}
		}
		
		/**
		 * 用item来更新list中等于item的对象 （一般都是id相等）
		 * @param list
		 * @param item 新对象的值
		 * 
		 */
		public static function updateItem(list:ArrayCollection, item:IEqualable):void{
			var index:int = LangUtil.getObjectIndex(item, list);
			copyProperties(list[index], item);
		}
		public static function fastUpdateItem(list:ArrayCollection, item:IEqualable):void{
			var index:int = LangUtil.getObjectIndex(item, list);
			list[index] = ObjectUtil.copy(item);
		}
		
		public static function findIndex(list:ArrayCollection,propertyName:String,item:Object):Number{
			for(var i:int = 0; i<list.length;i++) {
				var elm:Object = list.getItemAt(i);
				if(elm[propertyName] == item){
					return i;
				}
			}
			return -1;
		}
		
		public static function getDisplayText(val:String,arrs:ArrayCollection,propName:String,valName:String):String{
			for each(var obj:Object in arrs){
				if(obj[valName] == val){
					return obj[propName];
				}
			}
			return "";
		}

	}
}