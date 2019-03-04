<template>
<div style="background:white;">
	<div class="row mt-3" >
		<div class="col-md-12 col-lg-12">
      
        <el-col >
      <div>
        <router-link to = "/"><el-button><i class="el-icon-caret-left"></i> </el-button></router-link>
      </div>
  </el-col>
			<div class="card">
				<div class="card-body" >
					<form @submit.prevent="onSubmit" class="body">

						<div class="form-group">
							<label for="sn" >用户名</label>
							<input class="form-control" 
							:class="{ 'is-valid':Issuccess,'is-invalid':Isdanger}"
							@blur="checkSaleName" 
							v-model="salename" 
							placeholder="请输入用户名" 
							type="text" id="sn" style="width:800px;position:aboslute;	left:100px;">
							
							<div :class="[ classSelect ]" v-show="Isdanger||Issuccess" >
								{{ altermsg }}
							</div>
					        
							<label class="alert alert-warning" v-if="nIsEmpty" for="password" style="color:red">{{ nAlert }}</label>
						</div>

						<div class="form-group">
							<label for="ps">密码</label>
							<input class="form-control" 
							@blur="checkPassWord" 
							v-model="password" 
							placeholder="请输密码" 
							type="password" id="ps" style="width:800px;position:aboslute;	left:7px;">
							<label class="alert alert-warning" v-if="psIsEmpty" for="password" style="color:red">{{ psAlert }}</label>
						</div>

						<div class="form-group">
							<label for="nps">确认密码</label>
							<input class="form-control" 
							@blur="checkEnterPassWord" 
							v-model="enterpassword" 
							placeholder="请输密码" 
							type="password" id="nps" style="width:800px;position:aboslute;	left:7px;">
							<label class="alert alert-warning" v-if="epsIsEmpty" for="password" style="color:red">{{ epsAlert }}</label>
						</div>
            	<div class="form-group">
							<label for="nps">姓名</label>
							<input class="form-control" 
							@blur="checkname" 
							v-model="name" 
							placeholder="请输姓名" 
							type="text" id="nps" style="width:800px;position:aboslute;	left:7px;">
							<label class="alert alert-warning" v-if="nameIsEmpty" for="password" style="color:red">{{ nameAlert }}</label>
						</div>
						<label for="nps">证件类型：</label>
						    <el-radio-group v-model="certificate_type"  >
     						 <el-radio :label="1">身份证</el-radio>
     							 <el-radio :label="2">护照</el-radio>
  												  </el-radio-group>
            				<div class="form-group">
							<label for="nps">证件号</label>
							<input class="form-control" 
							@blur="checkcnum" 
							v-model="certificate_num" 
							placeholder="请输证件号" 
							type="text" id="nps" style="width:800px;position:aboslute;	left:7px;">
							<label class="alert alert-warning" v-if="cnumIsEmpty" for="password" style="color:red">{{ cnumAlert }}</label>
						</div>
            						<div class="form-group">
							<label for="nps">手机号</label>
							<input class="form-control" 
							@blur="checkmnum" 
							v-model="mobile_num" 
							placeholder="请输手机号" 
							type="text" id="nps" style="width:800px;position:aboslute;	left:7px;">
							<label class="alert alert-warning" v-if="mnumIsEmpty" for="password" style="color:red">{{ mnumAlert }}</label>
						</div>
            <div>
              <label for="nps">城市</label>
              <el-select v-model="register_city" placeholder="选择城市">
              <el-option
                 v-for="item in options"
                    :key="item.value"
               :label="item.label"
                 :value="item.value">
                     </el-option>
               </el-select>
            </div>

						<button type="submit" class="btn btn-block btn-success">注册</button>
					</form> 
				</div>
			</div>
		</div>
	</div>
</div>
</template>
<script>

import md5 from 'js-md5';
	export default{
		data(){
			return {
          options: [{
          value: '北京市 ',
          label: '北京市'
        }, {
          value: '天津市 ',
          label: '天津市'
        }, {
          value: '上海市 ',
          label: '上海市'
        }, {
          value: '重庆市 ',
          label: '重庆市'
        }, {
          value: '河北省 ',
          label: '河北省 '
        },
        {
          value: '山西省 ',
          label: '山西省 '
        }, {
          value: '台湾省 ',
          label: '台湾省 '
        }, {
          value: '辽宁省 ',
          label: '辽宁省 '
        }, {
          value: '吉林省 ',
          label: '吉林省 '
        }, {
          value: '黑龙江省 ',
          label: '黑龙江省 '
        },
        {
          value: '江苏省 ',
          label: '江苏省 '
        }, {
          value: '浙江省 ',
          label: '浙江省 '
        }, {
          value: '安徽省 ',
          label: '安徽省 '
        }, {
          value: '福建省 ',
          label: '福建省 '
        }, {
          value: '江西省 ',
          label: '江西省 '
        },
        {
          value: '山东省 ',
          label: '山东省 '
        }, {
          value: '河南省 ',
          label: '河南省 '
        }, {
          value: '湖北省 ',
          label: '湖北省 '
        }, {
          value: '湖南省 ',
          label: '湖南省 '
        }, {
          value: '广东省 ',
          label: '广东省 '
        },
        {
          value: '甘肃省 ',
          label: '甘肃省 '
        }, {
          value: '四川省 ',
          label: '四川省 '
        }, {
          value: '贵州省 ',
          label: '贵州省 '
        }, {
          value: '海南省 ',
          label: '海南省 '
        }, {
          value: '云南省 ',
          label: '云南省 '
        },
        {
          value: '青海省 ',
          label: '青海省 '
        }, {
          value: '陕西省 ',
          label: '陕西省 '
        }, {
          value: '广西壮族自治区 ',
          label: '广西壮族自治区 '
        }, {
          value: '西藏自治区 ',
          label: '西藏自治区 '
        }, {
          value: '宁夏回族自治区 ',
          label: '宁夏回族自治区 '
        },
        {
          value: '新疆维吾尔自治区 ',
          label: '新疆维吾尔自治区 '
        }, {
          value: '内蒙古自治区 ',
          label: '内蒙古自治区 '
        }, {
          value: '澳门特别行政区 ',
          label: '澳门特别行政区 '
        }, {
          value: '香港特别行政区 ',
          label: '香港特别行政区 '
        }],
        value: '',
      
				salename:'',
				password:'',
				password2:'',
				enterpassword:'',
				name:'',
				certificate_num:'',
				certificate_type:0,
				mobile_num:'',
				register_city:'',
				nIsEmpty:false,
				psIsEmpty:false,
				epsIsEmpty:false,
				nameIsEmpty:false,
				cnumIsEmpty:false,
				mnumIsEmpty:false,
				nAlert:'账号不能为空哦',
				psAlert:'密码不能为空哦',
				epsAlert:'密码不能为空哦',
				nameAlert:'姓名不能为空哦',
				cnumAlert:'证件号不能为空哦',
				mnumAlert:'电话不能为空哦',
				Issuccess:false,
				Isdanger:false,
				classSelect:'',
				altermsg:''
			}
		},
		methods:{
			getNowFormatDate () {
  var date = new Date();
  var seperator1 = "-";
  var year = date.getFullYear();
  var month = date.getMonth() + 1;
  var strDate = date.getDate();
   var strhours = date.getHours();
    var strminutes = date.getMinutes();
  if (month >= 1 && month <= 9) {
    month = "0" + month;
  }
  if (strDate >= 0 && strDate <= 9) {
    strDate = "0" + strDate;
  }
   if (strhours >= 1 && strhours <= 9) {
    strhours = "0" + strhours;
  }
  if (strminutes >= 0 && strminutes <= 9) {
    strminutes = "0" + strminutes;
  }
  var currentdate = year + seperator1 + month + seperator1 + strDate + ' ' + strhours +':'+ strminutes;
  return currentdate;
},
			onSubmit(){
				
            var regUpper = /[A-Z]/;
            var regLower = /[a-z]/;
			var regNum = /[0-9]/;
			var Numnum= /[A-Za-z]*[0-9][A-Za-z]*[0-9][A-Za-z]*/;
            var complex = 0;
            if (regLower.test(this.password)) {
                ++complex;
            }
            if (regUpper.test(this.password)) {
                ++complex;
			}
			console.log(complex);
			console.log(this.password.length);
			console.log(Numnum.test(this.password));
            if (complex < 2 || this.password.length < 8 || !Numnum.test(this.password)) {             
               this.$message.error("密码长度不小于8位，包含字母大、小写,至少包括两位数字")
               return false
            }else{
				if((this.certificate_type==1&&this.certificate_num.length!=18)||(this.mobile_num.length!=11))
				{
				this.$message.error("手机号或证件号格式有误")
               return false
				}
				else{
				console.log(1);
				let params = new URLSearchParams();
				params.append('user_name', this.salename);
				this.password2=md5(this.password);
				params.append('password', this.password2);
				params.append('user_type', 1);
				params.append('real_name', this.name);
				params.append('certificate_num', this.certificate_num);
				params.append('certificate_type', this.certificate_type);
				params.append('user_level', 0);
				params.append('register_time', this.$options.methods.getNowFormatDate());
				params.append('modify_time', this.$options.methods.getNowFormatDate());
				params.append('mobile_num', this.mobile_num);
				params.append('register_city', this.register_city);
				if (this.password===this.enterpassword&&this.Issuccess&&this.password!=''&&this.enterpassword!='') {
					this.$axios({                
						method:"post",                           
					url:'http://localhost:8080/RentHouseSystem/user/AddUser',               
					 data:params,                            
					 }).then(res=> {
						let resultjson=res.data;
						console.log(resultjson);
						if (resultjson.code!=0) {
							this.salename='';
							this.password='';
							this.nIsEmpty=false;
							this.psIsEmpty=false;
							this.Issuccess=false;
							this.Isdanger=false;
							this.$message({message: '注册成功,赶快登陆吧！',type: 'success'});
							//window.alert('注册成功,赶快登陆吧！');
							
						}else{
							//this.$message({message: '注册失败！',type: 'success'});
							this.$message.error('注册失败,网络异常！');
							//window.alert('注册失败,服务器错误,请重试！');
						}
					})
				}else if (this.password!=this.enterpassword) {
					this.$message({message: '两次密码不一样哦,请重新确认密码！',type: 'warning'});
					//window.alert('两次密码不一样哦,请重新确认密码');
				}else{
					this.$message({message: '表单数据不合法,请修正后再提交！',type: 'warning'});
					//window.alert('表单数据不合法,请修正后再提交');
				}
			}
			}
			},
			checkSaleName(){
				this.nIsEmpty=this.salename===''?true:false;
					  this.$axios({
				method:"get",
				url:"http://localhost:8080/RentHouseSystem/user/CheckUser",
				params:{
					user_name:this.salename
				}
					}).then(res=> {
					let Isexist=res.data;
					console.log(Isexist);
					if(this.nIsEmpty){
						console.log("走名字为空");
						this.classSelect='invalid-feedback';
						this.Issuccess=false;
						this.Isdanger=false;
					}else {
						
						if(Isexist){
							
							this.Issuccess=false;
							this.Isdanger=true;
							this.classSelect='invalid-feedback';
							console.log("名字不为空   账号已存在"+this.Issuccess,this.Isdanger);
							this.altermsg="这个是本网站的老用户了哦，快输入密码登录吧";
						}else if(!Isexist){
							
							this.Issuccess=true;
							this.Isdanger=false;
							this.classSelect='valid-feedback';
							console.log("名字不为空   账号不存在"+this.Issuccess,this.Isdanger);
							this.altermsg="你输入的账号可能还不存在，赶快去注册吧";
						}
					}
				})
            },
			checkPassWord(){
				this.psIsEmpty=this.password===''?true:false;
				
			},
			checkname(){
				this.nameIsEmpty=this.name===''?true:false;
				
			},
			checkcnum(){
				this.cnumIsEmpty=this.certificate_num===''?true:false;
				
			},
			checkmnum(){
				this.mnumIsEmpty=this.mobile_num===''?true:false;
				
			},
			checkEnterPassWord(){
				if (this.enterpassword!=''&&this.enterpassword===this.password) {
					this.epsIsEmpty=false;
				}else{
					this.epsAlert=this.enterpassword!=this.password?'两次密码不一样哦':'密码不能为空哦';
					this.epsIsEmpty=true;
				}
			}
		}
	}

</script>
<style scoped>
  body {
  background: #FFFFFF;
  }
</style>