(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-2ba356ff"],{"1da3":function(e,t,n){"use strict";var s=n("46a4"),o=n.n(s);o.a},"1e7a":function(e,t,n){},"3f5f":function(e,t,n){},"46a4":function(e,t,n){},"4c53":function(e,t,n){"use strict";var s=n("23e7"),o=n("857a"),i=n("af03");s({target:"String",proto:!0,forced:i("sub")},{sub:function(){return o(this,"sub","","")}})},"4c6d":function(e,t,n){"use strict";var s=n("1e7a"),o=n.n(s);o.a},"61ca":function(e,t,n){"use strict";var s=n("a7cc"),o=n.n(s);o.a},"71c2":function(e,t,n){"use strict";var s=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{staticClass:"header"},[n("el-row",[n("el-col",{attrs:{span:18,offset:3}},[n("div",{staticClass:"header_line"}),n("div",{staticClass:"header_a"},[n("span",[e._v(e._s(e.arr))])])])],1)],1)},o=[],i={props:["title"],data:function(){return{arr:this.title}},mounted:function(){}},a=i,r=(n("61ca"),n("2877")),l=Object(r["a"])(a,s,o,!1,null,"fa54168a",null);t["a"]=l.exports},"857a":function(e,t,n){var s=n("1d80"),o=/"/g;e.exports=function(e,t,n,i){var a=String(s(e)),r="<"+t;return""!==n&&(r+=" "+n+'="'+String(i).replace(o,"&quot;")+'"'),r+">"+a+"</"+t+">"}},a7cc:function(e,t,n){},af03:function(e,t,n){var s=n("d039");e.exports=function(e){return s((function(){var t=""[e]('"');return t!==t.toLowerCase()||t.split('"').length>3}))}},bb76:function(e,t,n){"use strict";var s=n("3f5f"),o=n.n(s);o.a},e0ae:function(e,t,n){"use strict";n.r(t);var s=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",[n("el-row",[n("headers",{attrs:{title:e.title}})],1),n("el-row",[n("el-col",{attrs:{span:18,offset:3}},[n("div",{staticClass:"news"},[n("div",{staticClass:"news_title"},[n("span",[e._v("新闻编辑")]),n("span",{staticClass:"r"},[n("span",{staticClass:"rs"},[e._v("*")]),n("span",[e._v("必填项")])])]),n("el-row",[n("el-col",{attrs:{span:20,offset:2}},[n("div",{staticClass:"news_form"},[n("el-row",[n("el-col",{attrs:{span:12}},[n("el-form",{ref:"form",attrs:{model:e.form,"label-width":"80px",rules:e.rules}},[n("el-form-item",{staticClass:"is-required",attrs:{label:"新闻版块"}},[n("el-select",{staticStyle:{width:"100%"},attrs:{placeholder:"请选择"},model:{value:e.form.section,callback:function(t){e.$set(e.form,"section",t)},expression:"form.section"}},e._l(e.options,(function(e,t){return n("el-option",{key:t,attrs:{label:e.press_name,value:e.id}})})),1)],1),n("el-form-item",{attrs:{label:"新闻标题",prop:"title"}},[n("el-input",{attrs:{maxlength:"20"},model:{value:e.form.title,callback:function(t){e.$set(e.form,"title",t)},expression:"form.title"}})],1),n("el-form-item",{staticClass:"is-required",attrs:{label:"新闻图片"}},[n("div",{staticClass:"files"},[e._v("+ "),n("div",{staticClass:"files_left"},[n("img",{staticStyle:{widows:"100px",height:"100px"},attrs:{src:e.image,alt:"",id:"image"}})]),n("div",{staticClass:"files_right"},[n("input",{staticClass:"form-control",attrs:{type:"file",name:"upload"},on:{change:e.onFileChange}})])])])],1)],1)],1),n("el-row",[n("el-col",[n("el-form",{attrs:{"label-width":"80px"}},[n("el-form-item",{staticClass:"is-required",attrs:{label:"新闻正文"}},[n("div",{attrs:{id:"editor"}},[n("p")])]),n("el-form-item",[n("el-button",{attrs:{type:"primary",id:"btn2"}},[e._v("保存草稿")]),n("el-button",{attrs:{type:"primary",id:"btn1"}},[e._v("发布")])],1)],1)],1)],1)],1)])],1)],1)])],1)],1)},o=[],i=(n("4c53"),n("71c2")),a=(n("bc3a"),{components:{headers:i["a"]},data:function(){return{title:"新闻编辑",poster:"",image:"",options:"",form:{section:"",title:"",author:"",text:"",id:""},rules:{title:[{required:!0,message:"标题不能为空"},{min:1,max:25,message:"不能超过25字"}]}}},methods:{onFileChange:function(e){var t=e.target.files||e.dataTransfer.files;t.length&&this.createImage(t[0])},createImage:function(e){new Image;var t=new FileReader,n=this;t.onload=function(e){n.image=e.target.result},t.readAsDataURL(e)},save:function(){var e,t=this;void 0==document.querySelector("input[type=file]").files[0]?(e="",this.$confirm("是否发布?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then((function(n){if("confirm"===n){var s=new window.FormData,o=window.sessionStorage.getItem("userId");s.append("file",e),s.append("title",t.form.title),s.append("particulars",t.form.text),s.append("userId",o),s.append("pressTypeId",t.form.section),s.append("id",t.form.id),t.$axios.post("/tomlive/pressCenter/updateNoFile",s,{headers:{"Content-Type":"multipart/form-data"}}).then((function(e){console.log(e),t.$axios.post("/tomlive/pressCenter/updatePressCenterStatus",t.$qs.stringify({id:t.form.id})).then((function(e){console.log(e),t.$router.push("/home/news_manage")})),t.$router.push("/home/news_fb_c")}))}})).catch((function(){t.$message({type:"info",message:"已取消"})}))):(e=document.querySelector("input[type=file]").files[0],this.$confirm("是否发布?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then((function(n){if("confirm"===n){var s=new window.FormData,o=window.sessionStorage.getItem("userId");s.append("file",e),s.append("title",t.form.title),s.append("particulars",t.form.text),s.append("userId",o),s.append("pressTypeId",t.form.section),s.append("id",t.form.id),t.$axios.post("/tomlive/pressCenter/updateByPrimaryKeySelective",s,{headers:{"Content-Type":"multipart/form-data"}}).then((function(e){t.$axios.post("/tomlive/pressCenter/updatePressCenterStatus",t.$qs.stringify({id:t.form.id})).then((function(e){console.log(e),t.$router.push("/home/news_manage")})),console.log(e),t.$router.push("/home/news_fb_c")}))}})).catch((function(){t.$message({type:"info",message:"已取消"})}))),console.log(e)},sub:function(){var e,t=this;void 0==document.querySelector("input[type=file]").files[0]?(e="",this.$confirm("是否发布?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then((function(n){if("confirm"===n){var s=new window.FormData,o=window.sessionStorage.getItem("userId");s.append("file",e),s.append("title",t.form.title),s.append("particulars",t.form.text),s.append("userId",o),s.append("pressTypeId",t.form.section),s.append("id",t.form.id),t.$axios.post("/tomlive/pressCenter/updateNoFile",s,{headers:{"Content-Type":"multipart/form-data"}}).then((function(e){console.log(e),t.$router.push("/home/news_fb_c")}))}})).catch((function(){t.$message({type:"info",message:"已取消"})}))):(e=document.querySelector("input[type=file]").files[0],this.$confirm("是否发布?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then((function(n){if("confirm"===n){var s=new window.FormData,o=window.sessionStorage.getItem("userId");s.append("file",e),s.append("title",t.form.title),s.append("particulars",t.form.text),s.append("userId",o),s.append("pressTypeId",t.form.section),s.append("id",t.form.id),t.$axios.post("/tomlive/pressCenter/updateByPrimaryKeySelective",s,{headers:{"Content-Type":"multipart/form-data"}}).then((function(e){console.log(e),t.$router.push("/home/news_fb_c")}))}})).catch((function(){t.$message({type:"info",message:"已取消"})}))),console.log(e)}},mounted:function(){var e=this,t=this,n=window.sessionStorage.getItem("news_d"),s=JSON.parse(n);this.form.id=s.id,console.log(s.particulars),this.form.title=s.title,this.image=s.photo;var o=window.wangEditor,i=new o("#editor");i.customConfig.uploadImgShowBase64=!0,i.customConfig.uploadImgMaxSize=3145728,i.customConfig.uploadImgMaxLength=5,i.create(),i.txt.html(s.particulars),document.getElementById("btn1").addEventListener("click",(function(){t.form.text=i.txt.html(),t.sub()}),!1),document.getElementById("btn2").addEventListener("click",(function(){t.form.text=i.txt.html(),t.save()}),!1),this.$axios.post("/tomlive/pressType/selectAllPressType").then((function(t){console.log(t),e.options=t.data.info,e.form.section=s.pressTypeId}))}}),r=a,l=(n("4c6d"),n("bb76"),n("1da3"),n("2877")),c=Object(l["a"])(r,s,o,!1,null,"0d04a1b4",null);t["default"]=c.exports}}]);
//# sourceMappingURL=chunk-2ba356ff.a84f6e57.js.map