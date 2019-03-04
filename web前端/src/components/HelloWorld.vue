<template>
<html>
<head>
<title>Home</title>
	</head>
	<br>
<el-menu
  :default-active="activeIndex2"
  class="el-menu-demo"
  mode="horizontal"
  @select="handleSelect"
  background-color="#cc00ff"
  text-color="#FFFFFF"
  active-text-color="#ffd04b"
  id='top'>
  <el-menu-item index="1" @click="changelink('manage2')" >租房广场</el-menu-item>
  <el-menu-item index="2" @click="changelink('/adddemand')">求租广场</el-menu-item>
   <el-menu-item index="3" :disabled="unLogon" @click="changelink('/myhouse')">个人信息</el-menu-item>
  <el-submenu index="4" :disabled="!IsAdmin">
    <template slot="title">管理员功能</template>
    <el-menu-item index="4-1" @click="changelink('/house_now')">租房信息管理</el-menu-item>
    <el-menu-item index="4-2" @click="changelink('/rent_now')">求租信息管理</el-menu-item>
    <el-menu-item index="4-3" @click="changelink('/user_manage')">用户信息管理</el-menu-item>
	<el-menu-item index="4-4" @click="changelink('/income')">统计数据查询</el-menu-item>
  </el-submenu>
 
</el-menu>

<body class="homepage">
			<div id="header">
				<div v-if="unLogon">
				<div id="input">
				<el-input v-model="account" placeholder="请输入账户" type="text" auto-complete="off"></el-input>
				</div>
				<div id="input1">
				<el-input v-model="password" placeholder="请输入密码" type="password" auto-complete="off"></el-input>	
				</div>
				<div id="logon">
				<el-button type="success" @click.native.prevent="handleSubmit">登录</el-button>
				</div>
				</div>
				<div v-else id="welcome">
					<!--p>欢迎回来！{{ account }}</p-->
					<el-alert
					:title = "'欢迎回来! ' + account"
					type="success"
					:closable="false">
					</el-alert>
				</div>
				
				<div id="register" v-if="unLogon">
					<!--<router-link to = "/register"><el-button type="text">注册</el-button></router-link>-->
					<!--el-button type="text" @click="dialogFormVisible = true">注册</el-button-->
					<el-button type="success" slot="reference" @click.native="changelink('/register')">注册</el-button>
					
				</div>
				<div v-else id="logout">
					<el-button type="danger" @click="logoff">注销</el-button>
				</div>
				<br><br><br><br><br><br>
				<!--div class="container"-->
					<!-- Logo -->
						<h1><a id="logo">海量新房源，省心上贝壳</a></h1>
					<!-- Nav -->
				<br><br><br><br>
				
					<!-- Banner -->

								<br><br><br><br>
								<br><br><br><br>
								<br>
			
									<br><br><br>
							</div>
			<!--/div-->

		<!-- Featured -->
		<div id="feature">
			<h1>精挑细选，品质保障</h1>
		
			<el-carousel :interval="4000" type="card" height="600px">
    <el-carousel-item v-for="item in 4" :key="item">
      <h3>{{ item }}</h3>
    </el-carousel-item>
  </el-carousel>
  </div>

					<!-- Copyright -->
						<div class="copyright">
							Design: <a href="http://templated.co">BUPTzhuxi</a> 
						</div>


	</body>
</html>
</template>

<script>
import md5 from 'js-md5';
export default {
  name: 'HelloWorld',
  data () {
    return {
		id:0,
		unLogon:true,
		IsAdmin:false,
	  msg: 'Welcome to Your Vue.js App',
	  password: '',
	  password2:"",
		account: '',
		result:[],
    visible2: false,
        dialogTableVisible: false,
        dialogFormVisible: false,
        form: {
          name: '',
          idcard: '',
          password: '',
          date2: '',
          delivery: false,
          type: [],
          resource: '',
          desc: ''
        },
        formLabelWidth: '120px'
    }
  },
  methods: {
    changelink(route){
            this.$router.replace(route);
        },
	  handleSubmit() {
		  if(this.password=='' || this.account=='')
		  {
			this.$notify.error({
            title: '错误',
            message:'账户名或密码不能为空',
            offset:50
            });
		  }
		  else{
			  this.$axios({
				method:"get",
				url:"http://localhost:8080/RentHouseSystem/user/CheckUser",
				params:{
					user_name:this.account
				}
			}).then((res)=>
			{
				let Isexist=res.data;
					console.log(Isexist);
					if(!Isexist)
					{
								this.$notify.error({
								title: '错误',
								message:'账户不存在',
								offset: 50
								})
					}
					if(Isexist)
					{	 
					this.password2=md5(this.password);
					console.log(this.password2);
				this.$axios({
				method:"get",
				url:"http://localhost:8080/RentHouseSystem/user/CheckPassword",
				params:{
					user_name:this.account,
					password:this.password2
				}
			}).then((res)=>
			{		let Isexist=res.data;
					console.log(Isexist);
					if(!Isexist)
					{
					this.$notify.error({
					title: '错误',
					message:'密码错误',
					offset: 50
					});
					}
					else
					{
				let params = new URLSearchParams();
          		params.append('user_name', this.account);

          		this.$axios({                
						method:"post",                           
					url:'http://localhost:8080/RentHouseSystem/user/UserInformation',               
					 data:params,                            
					 }).then(res=> {
             console.log(res);
			 this.id=res.data.user_id;
			 		   console.log('h'+this.id);
							var myarray = new Array(5);
							myarray[0] = this.account;
							myarray[1] = this.password;
							myarray[4] = this.id;
							myarray[5] = !res.data.user_type;
							//console.log(myarray);
							this.$store.commit('change',myarray);
							//console.log(this.$store.state);
							this.$notify({
								title: '成功',
								message:'欢迎回来，尊敬的 '+this.account,
								type: 'success',
								offset:50,
								
								});
								this.unLogon= false;
								this.IsAdmin= !res.data.user_type;
		   })
					}
					
					


		})
					}
			})


			
		  }
		 
	  },
	  logoff() {
			this.unLogon = true;
			this.IsAdmin =false;
			var myarray = new Array(4);
			myarray[0] = '0';
			myarray[1] = '0';
			myarray[2] = '';
			myarray[3] = 0;
			this.$store.commit('change',myarray);
			this.$notify({
								title: '成功',
								message:'您已成功注销！',
								type: 'success',
								offset: 50,
								
								});
		},
		check() {
			if(this.$store.state.account != '0')
			{
				this.unLogon = false;
				this.account = this.$store.state.account;
			}
			if(this.$store.state.isadmin == 1)
			{
				this.unLogon = false;
				this.IsAdmin = true;
				this.account = this.$store.state.account;
			}

		},
		              changelink(route){
    this.$router.replace(route);
  },
		
	},
	mounted(){
			this.check();
		}
}

</script>

<style >
@import '../../static/style.css';
@import 'element-ui/lib/theme-chalk/index.css';
.el-dropdown-link {
    cursor: pointer;
	color: #FFF;
	text-decoration: none;
	font-size: 21px;

}
.el-col {
	text-decoration: none;
	font-size: 21px;
}
a {

	color: #FFF;
	text-decoration: none;
}
hover a {
	color: #fff;
}
.el-icon-arrow-down {
	font-size: 18px;
}
#input{
	position : absolute;
	right:330px;
	top:5px;
	color:black;
}
#input1{
	position : absolute;
	right:140px;
	top:5px;
	color:black;
}
#logon{
	position : absolute;
	right:60px;
	top:5px
}
#top{
	position : absolute;
	right:16px;
	top:19px;
}
#register{
	position : absolute;
	right:0px;
	top:5px;
}
#welcome{
	position : absolute;
	right:90px;
	top:2px;
}
#logout{
	position : absolute;
	right:10px;
	top:5px;
}
#feature{
	text-align: center;
	color:white;
}
.el-carousel__item h3 {
    color: #475669;
    font-size: 14px;
    opacity: 0.75;
    line-height: 200px;
		margin: 0;
  }
  
  .el-carousel__item:nth-child(6n) {
		background-color: #99a9bf;
		background: url("../assets/pic01.jpg") no-repeat;
		background-size: cover;
  }
  
	.el-carousel__item:nth-child(6n+3) {
		background-color: #d3dce6;
		background: url("../assets/pic02.jpg") no-repeat;
		background-size: cover;
	}
	.el-carousel__item:nth-child(6n+4) {
		background-color: #d3dce6;
		background: url("../assets/pic03.jpg") no-repeat;
		background-size: cover;
	}
	.el-carousel__item:nth-child(6n+5) {
		background-color: #d3dce6;
		background: url("../assets/pic04.jpg") no-repeat;
		background-size: cover;
  }
	  .copyright {
	  text-align: center;
  }

</style>
