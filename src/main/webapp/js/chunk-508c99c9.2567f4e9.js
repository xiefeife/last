(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-508c99c9"],{"0025":function(t,e,n){"use strict";n.r(e);var r=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",[n("el-row",[n("headers",{attrs:{title:t.title}})],1),n("el-row",[n("el-col",{attrs:{span:18,offset:3}},[n("div",{staticClass:"post_container"},[n("div",{staticClass:"post_c_t"},[n("span",[t._v("岗位详情")]),n("span",{staticClass:"r",on:{click:t.r}},[t._v("返回列表")])]),n("div",{staticClass:"from_data"},[n("el-row",[n("el-col",{attrs:{span:12,offset:3}},[n("el-form",{ref:"form",attrs:{model:t.form,"label-width":"100px"}},[n("el-form-item",{attrs:{label:"岗位类型："}},[t._v(" "+t._s(t.form.post_type)+" ")]),n("el-form-item",{attrs:{label:"岗位名称："}},[t._v(" "+t._s(t.form.name)+" ")]),n("el-form-item",{attrs:{label:"岗位人数：",prop:"num"}},[t._v(" "+t._s(t.form.num)+" ")]),n("el-form-item",{attrs:{label:"岗位职责："}},t._l(t.form.responsibility.split("；"),(function(e,r){return n("div",{key:r},[t._v(" "+t._s(e)+" ")])})),0),n("el-form-item",{attrs:{label:"任职要求："}},t._l(t.form.Requirement.split("；"),(function(e,r){return n("div",{key:r},[t._v(" "+t._s(e)+" ")])})),0)],1)],1)],1)],1)])])],1)],1)},s=[],a=(n("b0c0"),n("71c2")),o={components:{headers:a["a"]},data:function(){return{title:"岗位详情",form:{post_type:"",name:"",num:"",responsibility:"",Requirement:"",id:""},options:[]}},methods:{r:function(){this.$router.push("/home/post_manage")}},mounted:function(){var t=window.sessionStorage.getItem("post_d"),e=JSON.parse(t);console.log(e),this.form.name=e.jobName,this.form.post_type=e.typeName,this.form.responsibility=e.jobStatement,this.form.Requirement=e.jobRequirement,this.form.num=e.talentNumber}},i=o,c=(n("3c52"),n("b158"),n("2877")),l=Object(c["a"])(i,r,s,!1,null,"6b46bbe7",null);e["default"]=l.exports},"3c52":function(t,e,n){"use strict";var r=n("f1d3"),s=n.n(r);s.a},"61ca":function(t,e,n){"use strict";var r=n("a7cc"),s=n.n(r);s.a},"71c2":function(t,e,n){"use strict";var r=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:"header"},[n("el-row",[n("el-col",{attrs:{span:18,offset:3}},[n("div",{staticClass:"header_line"}),n("div",{staticClass:"header_a"},[n("span",[t._v(t._s(t.arr))])])])],1)],1)},s=[],a={props:["title"],data:function(){return{arr:this.title}},mounted:function(){}},o=a,i=(n("61ca"),n("2877")),c=Object(i["a"])(o,r,s,!1,null,"fa54168a",null);e["a"]=c.exports},a7cc:function(t,e,n){},b0c0:function(t,e,n){var r=n("83ab"),s=n("9bf2").f,a=Function.prototype,o=a.toString,i=/^\s*function ([^ (]*)/,c="name";r&&!(c in a)&&s(a,c,{configurable:!0,get:function(){try{return o.call(this).match(i)[1]}catch(t){return""}}})},b158:function(t,e,n){"use strict";var r=n("e3b7"),s=n.n(r);s.a},e3b7:function(t,e,n){},f1d3:function(t,e,n){}}]);
//# sourceMappingURL=chunk-508c99c9.2567f4e9.js.map