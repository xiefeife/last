//手机号验证
export function isvalidPhone(str) {
	const reg = /^1[3|4|5|7|8][0-9]\d{8}$/;
	return reg.test(str);
}

//校验密码：只能输入4-20个字母、数字、下划线  
export function isvalidPass(str) {
	const reg = /^(\w){4,20}$/;
	return reg.test(str);
}

//  验证用户名  用户名要求 数字、字母、下划线的组合，其中数字和字母必须同时存在*
export function isvalidUsername(str) {
	const reg = /^[a-zA-Z]{1}([a-zA-Z0-9]|[._]){4,19}$/;
	return reg.test(str);
}