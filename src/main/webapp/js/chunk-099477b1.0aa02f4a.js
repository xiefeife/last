(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-099477b1"],{"1dde":function(t,e,n){var o=n("d039"),a=n("b622"),s=n("2d00"),r=a("species");t.exports=function(t){return s>=51||!o((function(){var e=[],n=e.constructor={};return n[r]=function(){return{foo:1}},1!==e[t](Boolean).foo}))}},"37a9":function(t,e,n){"use strict";n.r(e);var o=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",[n("el-row",[n("headers",{attrs:{title:t.title}})],1),n("el-row",[n("el-col",{attrs:{span:18,offset:3}},[n("div",{staticClass:"data_sift"},[n("div",{staticClass:"data_s_t"},[n("span",[t._v("数据筛选")])]),n("el-row",{attrs:{type:"flex",justify:"space-around"}},[n("el-col",{attrs:{span:5}},[n("div",{staticClass:"data_s_c"},[n("el-row",[n("el-col",{attrs:{span:7}},[n("span",[t._v("岗位名称：")])]),n("el-col",{attrs:{span:17}},[n("el-input",{model:{value:t.name,callback:function(e){t.name=e},expression:"name"}})],1)],1)],1)]),n("el-col",{attrs:{span:5}},[n("div",{staticClass:"data_s_c"},[n("el-row",[n("el-col",{attrs:{span:7}},[n("span",[t._v("岗位类型：")])]),n("el-col",{attrs:{span:17}},[n("el-select",{staticStyle:{width:"100%"},attrs:{placeholder:"请选择"},model:{value:t.post_t,callback:function(e){t.post_t=e},expression:"post_t"}},t._l(t.options,(function(t){return n("el-option",{key:t.id,attrs:{label:t.typeName,value:t.id}})})),1)],1)],1)],1)]),n("el-col",{attrs:{span:6}},[n("div",{staticClass:"data_s_c"},[n("el-row",[n("el-col",{attrs:{span:7}},[n("span",[t._v("发布时间：")])]),n("el-col",{attrs:{span:17}},[n("el-date-picker",{staticStyle:{width:"100%","font-size":"12px"},attrs:{type:"daterange","range-separator":"至","start-placeholder":"开始日期","end-placeholder":"结束日期"},model:{value:t.time,callback:function(e){t.time=e},expression:"time"}})],1)],1)],1)]),n("el-col",{attrs:{span:5}},[n("div",{staticClass:"data_s_c"},[n("el-button",{attrs:{type:"primary",icon:"el-icon-search"},on:{click:t.select}},[t._v("查询")])],1)])],1)],1),n("div",{staticClass:"post_content"},[n("div",{staticClass:"post_title"},[n("span",[t._v("数据列表")]),n("el-button",{attrs:{type:"primary",icon:"el-icon-plus"},on:{click:t.add}},[t._v("添加")])],1),n("div",{staticClass:"st"},[n("span",{class:0==t.num?"active":"",on:{click:t.on}},[t._v("已发布 ("+t._s(t.list.length)+")")]),n("span",{class:1==t.num?"active":"",on:{click:t.off}},[t._v("未发布 ("+t._s(t.lists.length)+")")])]),0==t.num?n("div",[n("el-table",{staticStyle:{width:"100%"},attrs:{data:t.list.slice((t.currentPage-1)*t.pagesize,t.currentPage*t.pagesize),"header-cell-style":t.rowClass,"cell-style":t.cellStyle,border:""}},[n("el-table-column",{attrs:{prop:"id",label:"序号"}}),n("el-table-column",{attrs:{prop:"jobName",label:"岗位名称"}}),n("el-table-column",{attrs:{prop:"typeName",label:"岗位类型"}}),n("el-table-column",{attrs:{label:"岗位职责","show-overflow-tooltip":""},scopedSlots:t._u([{key:"default",fn:function(e){return[n("span",[t._v(t._s(e.row.jobRequirement))])]}}],null,!1,3192572542)}),n("el-table-column",{attrs:{label:"岗位要求","show-overflow-tooltip":""},scopedSlots:t._u([{key:"default",fn:function(e){return[n("span",[t._v(t._s(e.row.jobStatement))])]}}],null,!1,4079805156)}),n("el-table-column",{attrs:{prop:"creationTime",label:"创建时间","show-overflow-tooltip":""}}),n("el-table-column",{attrs:{prop:"realName",label:"创建人"}}),n("el-table-column",{attrs:{label:"操作"},scopedSlots:t._u([{key:"default",fn:function(e){return[n("span",{staticStyle:{color:"#0079FE",cursor:"pointer"},on:{click:function(n){return n.stopPropagation(),t.re(e.$index,e.row.id)}}},[n("i",{staticClass:"el-icon-refresh"}),t._v(" 撤回")])]}}],null,!1,184355918)})],1),n("el-row",[n("div",{staticClass:"pages"},[n("el-pagination",{attrs:{background:"","current-page":t.currentPage,"page-size":t.pagesize,layout:"prev, pager, next, jumper",total:t.list.length},on:{"size-change":t.handleSizeChange,"current-change":t.handleCurrentChange,"update:currentPage":function(e){t.currentPage=e},"update:current-page":function(e){t.currentPage=e}}})],1)])],1):t._e(),1==t.num?n("div",[n("el-table",{staticStyle:{width:"100%"},attrs:{data:t.lists.slice((t.currentPage-1)*t.pagesize,t.currentPage*t.pagesize),"header-cell-style":t.rowClass,"cell-style":t.cellStyle,border:""},on:{"row-click":t.handle}},[n("el-table-column",{attrs:{prop:"id",label:"序号"}}),n("el-table-column",{attrs:{prop:"jobName",label:"岗位名称"}}),n("el-table-column",{attrs:{prop:"typeName",label:"岗位类型"}}),n("el-table-column",{attrs:{label:"岗位职责","show-overflow-tooltip":""},scopedSlots:t._u([{key:"default",fn:function(e){return[n("span",[t._v(t._s(e.row.jobRequirement))])]}}],null,!1,3192572542)}),n("el-table-column",{attrs:{label:"岗位要求","show-overflow-tooltip":""},scopedSlots:t._u([{key:"default",fn:function(e){return[n("span",[t._v(t._s(e.row.jobStatement))])]}}],null,!1,4079805156)}),n("el-table-column",{attrs:{prop:"creationTime",label:"创建时间","show-overflow-tooltip":""}}),n("el-table-column",{attrs:{prop:"realName",label:"创建人"}}),n("el-table-column",{attrs:{label:"操作"},scopedSlots:t._u([{key:"default",fn:function(e){return[n("span",{staticStyle:{color:"#0079FE",cursor:"pointer"},on:{click:function(n){return n.stopPropagation(),t.del(e.$index,e.row.id)}}},[n("i",{staticClass:"el-icon-delete"}),t._v(" 删除")])]}}],null,!1,1932776942)})],1),n("el-row",[n("div",{staticClass:"pages"},[n("el-pagination",{attrs:{background:"","current-page":t.currentPage,"page-size":t.pagesize,layout:"prev, pager, next, jumper",total:t.lists.length},on:{"size-change":t.handleSizeChange,"current-change":t.handleCurrentChange,"update:currentPage":function(e){t.currentPage=e},"update:current-page":function(e){t.currentPage=e}}})],1)])],1):t._e()])])],1)],1)},a=[],s=(n("4de4"),n("b0c0"),n("71c2")),r={components:{headers:s["a"]},data:function(){return{title:"岗位管理",currentPage:1,pagesize:20,total:1,post_list:[],num:0,name:"",post_t:"",time:"",options:[]}},methods:{formatDate:function(t){if("string"==typeof t)return this.formatDate2(t);var e=t.getFullYear(),n=t.getMonth()+1;n=n<10?"0"+n:n;var o=t.getDate();o=o<10?"0"+o:o;var a=t.getHours();a=a<10?"0"+a:a;var s=t.getMinutes();s=s<10?"0"+s:s;var r=t.getSeconds();return r=r<10?"0"+r:r,e+"-"+n+"-"+o+" "+a+"-"+s+"-"+r},handdle:function(t,e,n){console.log(t,e,n),window.sessionStorage.setItem("post_d",JSON.stringify(t)),this.$router.push("/home/post_d")},handle:function(t,e,n){console.log(t,e,n),window.sessionStorage.setItem("post_x",JSON.stringify(t)),this.$router.push("/home/post_edit")},re:function(t,e){var n=this,o=this;this.$confirm("确认撤回, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then((function(a){"confirm"===a&&o.$axios.post("/tomlive/talentRecruitment/updateByPrimaryKeyStatus",n.$qs.stringify({jobType:t.post_type,jobName:t.name,jobStatement:t.responsibility,jobRequirement:t.Requirement,talentNumber:t.num,id:e}),{headers:{}}).then((function(t){console.log(t),n.all()}))})).catch((function(){n.$message({type:"info",message:"取消撤回"})}))},reset:function(){this.name="",this.post_t="",this.time=""},select:function(){var t,e,n=this;""==this.time?(t="",e=""):(t=this.formatDate(this.time[0]),e=this.formatDate(this.time[1])),this.$axios.post("/tomlive/talentRecruitment/selectTalentRecruitmentByCondition",this.$qs.stringify({jobName:this.name,jobTypeId:this.post_t,beginTime:t,endTime:e})).then((function(t){n.post_list=t.data.info,console.log(n.post_list)}))},rowClass:function(t){t.row,t.rowIndex;return"text-align:center;background:#F5F5F5;color:#666"},cellStyle:function(t){t.row,t.column,t.rowIndex,t.columnIndex;return"text-align:center;"},handleSizeChange:function(t){console.log("每页 ".concat(t," 条"))},handleCurrentChange:function(t){console.log("当前页: ".concat(t))},formats:function(t,e,n){return 1===n?"发布":"未发布"},add:function(){this.$router.push("/home/new_post")},on:function(){this.num=0},off:function(){this.num=1},del:function(t,e){var n=this;console.log(e),this.$confirm("是否删除?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then((function(t){"confirm"===t&&n.$axios.post("/tomlive/talentRecruitment/deleteTalentRecruitmentByPrimaryKey",n.$qs.stringify({id:e})).then((function(t){console.log(t),n.all()}))})).catch((function(){n.$message({type:"info",message:"已取消"})}))},edit:function(t,e){console.log(t,e),window.sessionStorage.setItem("post_x",JSON.stringify(e)),this.$router.push("/home/post_edit")},all:function(){var t=this;this.$axios.post("/tomlive/talentRecruitment/selectAllTalentRecruitment").then((function(e){t.post_list=e.data.info.reverse(),t.total=t.post_list.length,console.log(t.post_list)}))}},mounted:function(){var t=this;this.all(),this.$axios.post("/tomlive/talentType/selectAllTalentType").then((function(e){t.options=e.data.info}))},computed:{list:function(){return this.post_list.filter((function(t){return 1==t.status}))},lists:function(){return this.post_list.filter((function(t){return 0==t.status}))}}},l=r,i=(n("d56b"),n("2877")),c=Object(i["a"])(l,o,a,!1,null,"1271832b",null);e["default"]=c.exports},"4de4":function(t,e,n){"use strict";var o=n("23e7"),a=n("b727").filter,s=n("1dde"),r=n("ae40"),l=s("filter"),i=r("filter");o({target:"Array",proto:!0,forced:!l||!i},{filter:function(t){return a(this,t,arguments.length>1?arguments[1]:void 0)}})},"61ca":function(t,e,n){"use strict";var o=n("a7cc"),a=n.n(o);a.a},"65f0":function(t,e,n){var o=n("861d"),a=n("e8b5"),s=n("b622"),r=s("species");t.exports=function(t,e){var n;return a(t)&&(n=t.constructor,"function"!=typeof n||n!==Array&&!a(n.prototype)?o(n)&&(n=n[r],null===n&&(n=void 0)):n=void 0),new(void 0===n?Array:n)(0===e?0:e)}},"71c2":function(t,e,n){"use strict";var o=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:"header"},[n("el-row",[n("el-col",{attrs:{span:18,offset:3}},[n("div",{staticClass:"header_line"}),n("div",{staticClass:"header_a"},[n("span",[t._v(t._s(t.arr))])])])],1)],1)},a=[],s={props:["title"],data:function(){return{arr:this.title}},mounted:function(){}},r=s,l=(n("61ca"),n("2877")),i=Object(l["a"])(r,o,a,!1,null,"fa54168a",null);e["a"]=i.exports},7877:function(t,e,n){},a7cc:function(t,e,n){},ae40:function(t,e,n){var o=n("83ab"),a=n("d039"),s=n("5135"),r=Object.defineProperty,l={},i=function(t){throw t};t.exports=function(t,e){if(s(l,t))return l[t];e||(e={});var n=[][t],c=!!s(e,"ACCESSORS")&&e.ACCESSORS,u=s(e,0)?e[0]:i,p=s(e,1)?e[1]:void 0;return l[t]=!!n&&!a((function(){if(c&&!o)return!0;var t={length:-1};c?r(t,1,{enumerable:!0,get:i}):t[1]=1,n.call(t,u,p)}))}},b0c0:function(t,e,n){var o=n("83ab"),a=n("9bf2").f,s=Function.prototype,r=s.toString,l=/^\s*function ([^ (]*)/,i="name";o&&!(i in s)&&a(s,i,{configurable:!0,get:function(){try{return r.call(this).match(l)[1]}catch(t){return""}}})},b727:function(t,e,n){var o=n("0366"),a=n("44ad"),s=n("7b0b"),r=n("50c4"),l=n("65f0"),i=[].push,c=function(t){var e=1==t,n=2==t,c=3==t,u=4==t,p=6==t,f=5==t||p;return function(d,m,h,g){for(var v,b,_=s(d),y=a(_),w=o(m,h,3),S=r(y.length),x=0,C=g||l,k=e?C(d,S):n?C(d,0):void 0;S>x;x++)if((f||x in y)&&(v=y[x],b=w(v,x,_),t))if(e)k[x]=b;else if(b)switch(t){case 3:return!0;case 5:return v;case 6:return x;case 2:i.call(k,v)}else if(u)return!1;return p?-1:c||u?u:k}};t.exports={forEach:c(0),map:c(1),filter:c(2),some:c(3),every:c(4),find:c(5),findIndex:c(6)}},d56b:function(t,e,n){"use strict";var o=n("7877"),a=n.n(o);a.a},e8b5:function(t,e,n){var o=n("c6b6");t.exports=Array.isArray||function(t){return"Array"==o(t)}}}]);
//# sourceMappingURL=chunk-099477b1.0aa02f4a.js.map