$.dialog({title:'提示',
    content: varObj.returnMsg,
    type:'错误',
    cancel:function($dialog){
    $dialog.trigger("dialog-close");
    var dialog = parent.dialog.get(window);
    dialog.close();
    dialog.remove();
    },
});
$('#2000143768').attr("disabled","disabled");