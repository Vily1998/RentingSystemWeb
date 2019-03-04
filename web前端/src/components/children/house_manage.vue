<template>
  <div>
      <div class="line"></div>
      <!--router-link @click.native="handleDelete('000',flag);addone()" :to="{path:this.$store.state.count}">{{this.$store.state.count}}</router-link-->
          <el-menu
            :default-active="activeIndex2"
            class="el-menu-demo"
            mode="horizontal"
            @select="handleSelect"
            background-color="#00B8EC"
            text-color="#fff"
            active-text-color="#ffd04b">
            <el-menu-item index="1" @click="changelink('/manage2')">查看现有房源</el-menu-item>
          </el-menu>
          <el-card class="box-card" shadow="hover" body-style="height:860px" >
            <div class="card" >
              
				<div class="card-body" >
					<form @submit.prevent="onSubmit" class="body">
            
<el-row>
  <div >
    
    <el-col :span="1">
    <p>{{hello}}</p>
      </el-col>
    <el-select v-model="city_name" placeholder="选择城市">
    <el-option
      v-for="item in options"
      :key="item.value"
      :label="item.label"
      :value="item.value">
    </el-option>
  </el-select>
  </div>
  </el-row>
 <el-row>
  <div >
    <el-col :span="1">
    <p>{{hello2}}</p>
      </el-col>
      <el-col :span="2">
<el-input v-model="community_name" placeholder="请输入具体位置" style="width:400px;position:aboslute;	"></el-input>
</el-col>
  </div>
  </el-row>
  <el-row>
  <div >
    <el-col :span="1">
    <p>{{hello4}}</p>
      </el-col>
      <el-col :span="2" >
<el-input v-model="house_num" style="width:400px;position:aboslute;	"></el-input>
</el-col>
  </div>
  </el-row>

    <el-row>
  <div >
    <el-col :span="1">
    <p>{{hello5}}</p>
      </el-col>
    <el-radio-group v-model="house_type" id='s1' >
      <el-radio :label="1">一居</el-radio>
      <el-radio :label="2">两居</el-radio>
      <el-radio :label="3">三居</el-radio>
      <el-radio :label="4">四居+</el-radio>
    </el-radio-group>
  </div>
  </el-row>
     <el-row>
  <div >
    <el-col :span="1">
    <p>{{hello6}}</p>
      </el-col>
    <el-radio-group v-model="is_elevator" id='s2' >
      <el-radio :label="1">是</el-radio>
      <el-radio :label="0">否</el-radio>
    </el-radio-group>
  </div>
  </el-row>
    <el-row>
  <div >
    <el-col :span="1">
    <p>{{hello7}}</p>
      </el-col>
      <el-col :span="2" >
<el-input v-model="house_floor" style="width:120px;position:aboslute;	"></el-input>
</el-col>
  </div>
  </el-row>
    <el-row>
  <div >
    <el-col :span="1">
    <p>{{hello8}}</p>
      </el-col>
      <el-col :span="2" >
<el-input v-model="house_area" placeholder="单位：平方米" style="width:120px;position:aboslute;	"></el-input>
</el-col>
  </div>
  </el-row>
    <el-row>
  <div >
    <el-col :span="1">
    <p>{{hello10}}</p>
      </el-col>
      <el-col :span="2" >
<el-input v-model="description" style="width:400px;position:aboslute;	"></el-input>
</el-col>
  </div>
  </el-row>
    <el-row>
  <div >
    <el-col :span="1">
    <p>{{hello11}}</p>
      </el-col>
      <el-col :span="2" >
<el-input v-model="deposit"  placeholder="单位：月" style="width:150px;position:aboslute;	"></el-input>
</el-col>
  </div>
  </el-row>
       <el-row>
  <div >
    <el-col :span="1">
    <p>{{hello12}}</p>
      </el-col>
    <el-radio-group v-model="payment_method" id='s3' >
      <el-radio :label="1">月</el-radio>
      <el-radio :label="2">季</el-radio>
       <el-radio :label="3">年</el-radio>
    </el-radio-group>
  </div>
  </el-row>
  <el-row>
  <div >
    <el-col :span="1">
    <p>{{hello13}}</p>
      </el-col>
      <el-col :span="2" >
<el-input v-model="rent_per_month"  placeholder="单位：元" style="width:150px;position:aboslute;	"></el-input>
</el-col>
  </div>
  </el-row>
  

						<button type="submit" class="btn btn-block btn-success">发布</button>
					</form> 
				</div>
			</div>
      <div>
    <img src="../../assets/backh.jpg" height="900" width="948" style="position:absolute; left:600px; top:69px; "/>
    </div>
</el-card>

  </div>
  </template>
  
<script>
    export default {
      data() {
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
        house_id:0,
user_id:0,
city_name: '',
community_name: '',
house_num: '',
house_type: 0,
house_area: 0,
house_floor: 0,
is_elevator: 0,
description: '',
deposit: 0,
payment_method: 0,
rent_per_month: 0,
register_time: '',
modify_time: '',
state: 0,
                  hello:'地区：',
        hello2:'街区：',
        hello4:'具体门楼号：',
        hello5:'房型：',
        hello6:'是否电梯：',
        hello7:'楼层:',
        hello8:'面积:',
        hello9:'图片:',
        hello10:'房屋家居描述：',
        hello11:'押金：',
        hello12:'租金支付方式：',
        hello13:'每月租金：',
        hello14:'状态：',
        dialogImageUrl: '',
        dialogVisible: false,
        }
      },
      methods: {
        handleRemove(file, fileList) {
        console.log(file, fileList);
      },
                     changelink(route){
            this.$router.replace(route);
        },
      handlePictureCardPreview(file) {
        this.dialogImageUrl = file.url;
        this.dialogVisible = true;
      },
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
        let params = new URLSearchParams();
        this.user_id=this.$store.state.id;
        console.log(this.user_id);
				params.append('user_id', this.user_id);
				params.append('city_name', this.city_name);
				params.append('community_name', this.community_name);
				params.append('house_num', this.house_num);
				params.append('house_type', this.house_type);
				params.append('house_area', this.house_area);
        params.append('house_floor', this.house_floor);
        params.append('is_elevator', this.is_elevator);
        params.append('description', this.description);
        params.append('deposit', this.deposit);
        params.append('payment_method', this.payment_method);
				params.append('rent_per_month', this.rent_per_month);
				params.append('register_time', this.$options.methods.getNowFormatDate());
				params.append('modify_time', this.$options.methods.getNowFormatDate());
				params.append('state', this.state); 
					this.$axios({                
						method:"post",                           
					url:'http://localhost:8080/RentHouseSystem/house/AddHouse',               
					 data:params,                            
					 }).then(res=> {
						let resultjson=res.data;
						console.log(resultjson);
						if (resultjson!=0) {
              this.house_id=resultjson;

              this.$message({message: '发布成功！',type: 'success'});
              console.log(this.house_id);
        this.$router.push({
                    path:"/addphoto",//跳转路由
                    query:{//参数对象
                        house_id:this.house_id,
                    }
        })
               
							
						}else{
							//this.$message({message: '注册失败！',type: 'success'});
							this.$message.error('注册失败,网络异常！');
							//window.alert('注册失败,服务器错误,请重试！');
						}
          })

			},       
},
 
      }
    
  </script>

<style scoped>
  #logons{
	position : absolute;
	left:250px;
  top:30px;
  }
  .el-col {
	text-decoration: none;
	font-size: 15px;
}
</style>