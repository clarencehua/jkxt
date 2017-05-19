/**
 * 请求多选框的封装方法
 * 
 * @author 曲波
 */
var MultiSelect = function() {
	var ajaxMultiSelect = function(id, url, data) {
		$.ajax({
			type : "post",
			url : url,
			dataType : "json",
			data : data,
			success : function(result) {
				ajaxMultiSelectCallback(id, result);
			}
		});
	}
	var ajaxMultiSelectOptgroup = function(id, url, data) {
		$.ajax({
			type : "post",
			url : url,
			dataType : "json",
			data : data,
			success : function(result) {
				ajaxMultiSelectOptgroupCallback(id, result);
			}
		});
	}
	function ajaxMultiSelectOptgroupCallback(id, result) {
		destroy(id);
		initMultiSelect(id, true);
		for (var i = 0; i < result.length; i++) {
			var html = "<optgroup label='" + result[i].text + "'></optgroup>";
			$(id).append(html);
			var child = result[i].childMultiSelectModel;
			for (var j = 0; j < child.length; j++) {
				var option = setOption(child[j], j);
				$(id).multiSelect("addOption", option);
				if (child[j].select) {
					$(id).multiSelect("select", option.value);
				}
			}
		}
		//不加这句，会出现：optgroup在初始化的时候，全部显示
		initMultiSelect(id,true);
	}

	function ajaxMultiSelectCallback(id, result) {
		initMultiSelect(id, false);
		for (var i = 0; i < result.length; i++) {
			var option = setOption(result[i]);
			$(id).multiSelect("addOption", option);
			if (result[i].select) {
				$(id).multiSelect("select", option.value);
			}
		}
	}

	function setOption(data,j) {
		return {
			value : data.value,
			text : data.text,
			index : j,
			nested : data.nested
		};
	}
	
	function destroy(id){
		if($(id).multiSelect!=undefined&&$(id).multiSelect!=null){
			$(id).multiSelect("destroy");
			$(id).html('');
		}
	}

	function initMultiSelect(id, isOptgroup) {
		if($(id).multiSelect!=undefined&&$(id).multiSelect!=null){
			$(id).multiSelect("destroy");
		}
		$(id).multiSelect(
						{
							selectableOptgroup : isOptgroup,
							selectableHeader : "<input type='text' class='search-input form-control' autocomplete='off' placeholder='关键字'>",
							selectionHeader : "<input type='text' class='search-input form-control' autocomplete='off' placeholder='关键字'>",
							afterInit : function(ms) {
								var that = this, $selectableSearch = that.$selectableUl
										.prev(), $selectionSearch = that.$selectionUl
										.prev(), selectableSearchString = '#'
										+ that.$container.attr('id')
										+ ' .ms-elem-selectable:not(.ms-selected)', selectionSearchString = '#'
										+ that.$container.attr('id')
										+ ' .ms-elem-selection.ms-selected';

								that.qs1 = $selectableSearch.quicksearch(
										selectableSearchString).on('keydown',
										function(e) {
											if (e.which === 40) {
												that.$selectableUl.focus();
												return false;
											}
										});

								that.qs2 = $selectionSearch.quicksearch(
										selectionSearchString).on('keydown',
										function(e) {
											if (e.which == 40) {
												that.$selectionUl.focus();
												return false;
											}
										});
							},
							afterSelect : function() {
								this.qs1.cache();
								this.qs2.cache();
							},
							afterDeselect : function() {
								this.qs1.cache();
								this.qs2.cache();
							}
						});
	}
	return {
		initAjaxMultiSelect : function(id, url, data) {
			ajaxMultiSelect(id, url, data);
		},
		initAjaxMultiSelectOptgroup : function(id, url, data) {
			ajaxMultiSelectOptgroup(id, url, data);
		},
		destory:function(id){
			destroy(id);
		},
		initMultiSelect:function(id,optgroup){
			initMultiSelect(id,optgroup);
		}
	}
}();