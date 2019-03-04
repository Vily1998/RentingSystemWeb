<template>
  <html>
    <head>
      <title>房源信息</title>
    </head>
    <body>
<el-menu
  :default-active="activeIndex2"
  class="el-menu-demo"
  mode="horizontal"
  @select="handleSelect"
  background-color="#00B8EC"
  text-color="#fff"
  active-text-color="#ffd04b">
  <el-menu-item index="1" @click="changelink('/')">主页</el-menu-item>
  <el-menu-item index="2" @click="changelink('/house_manage')">发布房源</el-menu-item>
<el-menu-item index="3"  @click="changelink('/Calendar')">ID搜房</el-menu-item>
</el-menu>

              <el-card class="box-card" shadow="hover" body-style="height:450px">
            <div class="card">
   	<div class="card-body" >
					<form @submit.prevent="onSubmit" class="body">
<el-row>
  <div >
    <el-col :span="2">
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
    <el-col :span="2">
    <p>{{hello2}}</p>
      </el-col>
      <el-col :span="2">
<el-input v-model="community_name" placeholder="请输入具体位置"></el-input>
</el-col>
  </div>
  </el-row>
 <el-row>
  <div >
    <el-col :span="2">
    <p>{{hello3}}</p>
      </el-col>
      <el-col :span="2.2" >
<el-input v-model="min_area" style="width:120px;position:aboslute;"></el-input>
</el-col>
 <el-col :span="4" >
    <p>{{hello4}}</p>
    </el-col>
     <el-col :span="2" >
<el-input v-model="max_area" style="width:120px;position:aboslute;	left:-135px;"></el-input>
</el-col>
  </div>
  </el-row>
    <el-row>
  <div >
    <el-col :span="2">
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
    <el-col :span="2">
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
    <el-col :span="2">
    <p>{{hello7}}</p>
      </el-col>
<el-input v-model="descriptiont" style="width:300px;position:aboslute;"></el-input>
  </div>
      </el-row>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<button type="submit" class="btn btn-block btn-success">查询</button>
	</form> 

  </div>
  </div>
        </el-card>
  <div v-if="length>0">
      <span v-for="n in up">
        <el-button  @click="setDialogVisible(n,1)">
          <el-container>
          <el-aside width="70px">
            
          </el-aside>
          <el-aside width="280px">
            <span v-for="m in mlength">
              <span v-if="photoData[m-1].house_id===tableData[down+n-2].house_id">
                {{photoData[m-1].photo}}
                <img :src="photoData[m-1].data" alt="照片尚未上传" height="200" width="264"/>
              </span>
            </span>
          </el-aside>
          <el-aside width="1125px">
            <br>
            <br>
            <br>
            <br>
            <br>
            <font size="5" color="orange">{{tableData[down+n-2].description}}</font>
            <br>
            <font size="3" color="orange"><br>{{tableData[down+n-2].community_name}}  &nbsp;&nbsp;&nbsp;{{tableData[down+n-2].house_type}} &nbsp;&nbsp;&nbsp;{{tableData[down+n-2].house_area}}平方米</font>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            
            
          </el-aside>
          <el-aside width="500px">
            <br><br><br><br><br><br><font size="5" color="orange">{{tableData[down+n-2].rent_per_month}}元/月</font>
          </el-aside>
          </el-container>
        </el-button>
        <br>
        
      </span>
      <div>
      </div>
      
      <div class="block">
        <el-pagination
        layout="prev, pager, next"
        :total="length"
        @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page="page"
        >
        </el-pagination>
      </div>

      <el-dialog
          title="房源信息"
          :visible.sync="dialogVisible1"
          width="30%"
        >
        <span v-for="n in up">
          <span v-if="n === 1">
              <div align="center"><h3>{{tableData[down+n-2].description}}</h3><br></div>
              城市： {{tableData[down+n-2].city_name}}<br>
              街区： {{tableData[down+n-2].community_name}}<br>
              房型： {{tableData[down+n-2].house_type}}<br>
              面积： {{tableData[down+n-2].house_area}}<br>
              楼层： {{tableData[down+n-2].house_floor}}<br>
              电梯： {{tableData[down+n-2].is_elevator}}<br>
              押金： {{tableData[down+n-2].deposit}}<br>
              支付： {{tableData[down+n-2].payment_method}}<br>
              租金： {{tableData[down+n-2].rent_per_month}}<br>
              最近修改时间： {{tableData[down+n-2].modify_time}}<br>
              状态： {{tableData[down+n-2].state}}<br>
              <br>
            <span slot="footer" class="dialog-footer">
            <div align="center">
            <el-button @click="setDialogVisible(n,0)">取 消</el-button>
            <el-button type="primary" :disabled="$store.state.id==tableData[down+n-2].user_id" @click="form.house_id=tableData[down+n-2].house_id,setDialogVisible(n,0),dialogFormVisible=true">我要租</el-button>
            </div>
            </span>
          </span>
        </span>
      </el-dialog>

<el-dialog
          title="房源信息"
          :visible.sync="dialogVisible2"
          width="30%"
        >
        <span v-for="n in up">
          <span v-if="n === 2">
              <div align="center"><h3>{{tableData[down+n-2].description}}</h3><br></div>
              城市： {{tableData[down+n-2].city_name}}<br>
              街区： {{tableData[down+n-2].community_name}}<br>
              房型： {{tableData[down+n-2].house_type}}<br>
              面积： {{tableData[down+n-2].house_area}}<br>
              楼层： {{tableData[down+n-2].house_floor}}<br>
              电梯： {{tableData[down+n-2].is_elevator}}<br>
              押金： {{tableData[down+n-2].deposit}}<br>
              支付： {{tableData[down+n-2].payment_method}}<br>
              租金： {{tableData[down+n-2].rent_per_month}}<br>
              最近修改时间： {{tableData[down+n-2].modify_time}}<br>
              状态： {{tableData[down+n-2].state}}<br>
              <br>
            <span slot="footer" class="dialog-footer">
            <div align="center">
            <el-button @click="setDialogVisible(n,0)">取 消</el-button>
            <el-button type="primary" :disabled="$store.state.id==tableData[down+n-2].user_id" @click="form.house_id=tableData[down+n-2].house_id,setDialogVisible(n,0),dialogFormVisible=true">我要租</el-button>
            </div>
            </span>
          </span>
        </span>
      </el-dialog>

      <el-dialog
          title="房源信息"
          :visible.sync="dialogVisible3"
          width="30%"
        >
        <span v-for="n in up">
          <span v-if="n === 3">
              <div align="center"><h3>{{tableData[down+n-2].description}}</h3><br></div>
              城市： {{tableData[down+n-2].city_name}}<br>
              街区： {{tableData[down+n-2].community_name}}<br>
              房型： {{tableData[down+n-2].house_type}}<br>
              面积： {{tableData[down+n-2].house_area}}<br>
              楼层： {{tableData[down+n-2].house_floor}}<br>
              电梯： {{tableData[down+n-2].is_elevator}}<br>
              押金： {{tableData[down+n-2].deposit}}<br>
              支付： {{tableData[down+n-2].payment_method}}<br>
              租金： {{tableData[down+n-2].rent_per_month}}<br>
              最近修改时间： {{tableData[down+n-2].modify_time}}<br>
              状态： {{tableData[down+n-2].state}}<br>
              <br>
            <span slot="footer" class="dialog-footer">
            <div align="center">
            <el-button @click="setDialogVisible(n,0)">取 消</el-button>
            <el-button type="primary" :disabled="$store.state.id==tableData[down+n-2].user_id" @click="form.house_id=tableData[down+n-2].house_id,setDialogVisible(n,0),dialogFormVisible=true">我要租</el-button>
            </div>
            </span>
          </span>
        </span>
      </el-dialog>

      <el-dialog
          title="房源信息"
          :visible.sync="dialogVisible4"
          width="30%"
        >
        <span v-for="n in up">
          <span v-if="n === 4">
              <div align="center"><h3>{{tableData[down+n-2].description}}</h3><br></div>
              城市： {{tableData[down+n-2].city_name}}<br>
              街区： {{tableData[down+n-2].community_name}}<br>
              房型： {{tableData[down+n-2].house_type}}<br>
              面积： {{tableData[down+n-2].house_area}}<br>
              楼层： {{tableData[down+n-2].house_floor}}<br>
              电梯： {{tableData[down+n-2].is_elevator}}<br>
              押金： {{tableData[down+n-2].deposit}}<br>
              支付： {{tableData[down+n-2].payment_method}}<br>
              租金： {{tableData[down+n-2].rent_per_month}}<br>
              最近修改时间： {{tableData[down+n-2].modify_time}}<br>
              状态： {{tableData[down+n-2].state}}<br>
              <br>
            <span slot="footer" class="dialog-footer">
            <div align="center">
            <el-button @click="setDialogVisible(n,0)">取 消</el-button>
            <el-button type="primary" :disabled="$store.state.id==tableData[down+n-2].user_id"  @click="form.house_id=tableData[down+n-2].house_id,setDialogVisible(n,0),dialogFormVisible=true">我要租</el-button>
            </div>
            </span>
          </span>
        </span>
      </el-dialog>

      <el-dialog
          title="房源信息"
          :visible.sync="dialogVisible5"
          width="30%"
        >
        <span v-for="n in up">
          <span v-if="n === 5">
              <div align="center"><h3>{{tableData[down+n-2].description}}</h3><br></div>
              城市： {{tableData[down+n-2].city_name}}<br>
              街区： {{tableData[down+n-2].community_name}}<br>
              房型： {{tableData[down+n-2].house_type}}<br>
              面积： {{tableData[down+n-2].house_area}}<br>
              楼层： {{tableData[down+n-2].house_floor}}<br>
              电梯： {{tableData[down+n-2].is_elevator}}<br>
              押金： {{tableData[down+n-2].deposit}}<br>
              支付： {{tableData[down+n-2].payment_method}}<br>
              租金： {{tableData[down+n-2].rent_per_month}}<br>
              最近修改时间： {{tableData[down+n-2].modify_time}}<br>
              状态： {{tableData[down+n-2].state}}<br>
              <br>
            <span slot="footer" class="dialog-footer">
            <div align="center">
            <el-button @click="setDialogVisible(n,0)">取 消</el-button>
            <el-button type="primary" :disabled="$store.state.id==tableData[down+n-2].user_id" @click="form.house_id=tableData[down+n-2].house_id,setDialogVisible(n,0),dialogFormVisible=true">我要租</el-button>
            </div>
            </span>
          </span>
        </span>
      </el-dialog>

      <el-dialog
          title="房源信息"
          :visible.sync="dialogVisible6"
          width="30%"
        >
        <span v-for="n in up">
          <span v-if="n === 6">
              <div align="center"><h3>{{tableData[down+n-2].description}}</h3><br></div>
              城市： {{tableData[down+n-2].city_name}}<br>
              街区： {{tableData[down+n-2].community_name}}<br>
              房型： {{tableData[down+n-2].house_type}}<br>
              面积： {{tableData[down+n-2].house_area}}<br>
              楼层： {{tableData[down+n-2].house_floor}}<br>
              电梯： {{tableData[down+n-2].is_elevator}}<br>
              押金： {{tableData[down+n-2].deposit}}<br>
              支付： {{tableData[down+n-2].payment_method}}<br>
              租金： {{tableData[down+n-2].rent_per_month}}<br>
              最近修改时间： {{tableData[down+n-2].modify_time}}<br>
              状态： {{tableData[down+n-2].state}}<br>
              <br>
            <span slot="footer" class="dialog-footer">
            <div align="center">
            <el-button @click="setDialogVisible(n,0)">取 消</el-button>
            <el-button type="primary" :disabled="$store.state.id==tableData[down+n-2].user_id" @click="form.house_id=tableData[down+n-2].house_id,setDialogVisible(n,0),dialogFormVisible=true">我要租</el-button>
            </div>
            </span>
          </span>
        </span>
      </el-dialog>

      <el-dialog
          title="房源信息"
          :visible.sync="dialogVisible7"
          width="30%"
        >
        <span v-for="n in up">
          <span v-if="n === 7">
              <div align="center"><h3>{{tableData[down+n-2].description}}</h3><br></div>
              城市： {{tableData[down+n-2].city_name}}<br>
              街区： {{tableData[down+n-2].community_name}}<br>
              房型： {{tableData[down+n-2].house_type}}<br>
              面积： {{tableData[down+n-2].house_area}}<br>
              楼层： {{tableData[down+n-2].house_floor}}<br>
              电梯： {{tableData[down+n-2].is_elevator}}<br>
              押金： {{tableData[down+n-2].deposit}}<br>
              支付： {{tableData[down+n-2].payment_method}}<br>
              租金： {{tableData[down+n-2].rent_per_month}}<br>
              最近修改时间： {{tableData[down+n-2].modify_time}}<br>
              状态： {{tableData[down+n-2].state}}<br>
              <br>
            <span slot="footer" class="dialog-footer">
            <div align="center">
            <el-button @click="setDialogVisible(n,0)">取 消</el-button>
            <el-button type="primary" :disabled="$store.state.id==tableData[down+n-2].user_id" @click="form.house_id=tableData[down+n-2].house_id,setDialogVisible(n,0),dialogFormVisible=true">我要租</el-button>
            </div>
            </span>
          </span>
        </span>
      </el-dialog>

      <el-dialog
          title="房源信息"
          :visible.sync="dialogVisible8"
          width="30%"
        >
        <span v-for="n in up">
          <span v-if="n === 8">
              <div align="center"><h3>{{tableData[down+n-2].description}}</h3><br></div>
              城市： {{tableData[down+n-2].city_name}}<br>
              街区： {{tableData[down+n-2].community_name}}<br>
              房型： {{tableData[down+n-2].house_type}}<br>
              面积： {{tableData[down+n-2].house_area}}<br>
              楼层： {{tableData[down+n-2].house_floor}}<br>
              电梯： {{tableData[down+n-2].is_elevator}}<br>
              押金： {{tableData[down+n-2].deposit}}<br>
              支付： {{tableData[down+n-2].payment_method}}<br>
              租金： {{tableData[down+n-2].rent_per_month}}<br>
              最近修改时间： {{tableData[down+n-2].modify_time}}<br>
              状态： {{tableData[down+n-2].state}}<br>
              <br>
            <span slot="footer" class="dialog-footer">
            <div align="center">
            <el-button @click="setDialogVisible(n,0)">取 消</el-button>
            <el-button type="primary" :disabled="$store.state.id==tableData[down+n-2].user_id" @click="form.house_id=tableData[down+n-2].house_id,setDialogVisible(n,0),dialogFormVisible=true">我要租</el-button>
            </div>
            </span>
          </span>
        </span>
      </el-dialog>

      <el-dialog
          title="房源信息"
          :visible.sync="dialogVisible9"
          width="30%"
        >
        <span v-for="n in up">
          <span v-if="n === 9">
              <div align="center"><h3>{{tableData[down+n-2].description}}</h3><br></div>
              城市： {{tableData[down+n-2].city_name}}<br>
              街区： {{tableData[down+n-2].community_name}}<br>
              房型： {{tableData[down+n-2].house_type}}<br>
              面积： {{tableData[down+n-2].house_area}}<br>
              楼层： {{tableData[down+n-2].house_floor}}<br>
              电梯： {{tableData[down+n-2].is_elevator}}<br>
              押金： {{tableData[down+n-2].deposit}}<br>
              支付： {{tableData[down+n-2].payment_method}}<br>
              租金： {{tableData[down+n-2].rent_per_month}}<br>
              最近修改时间： {{tableData[down+n-2].modify_time}}<br>
              状态： {{tableData[down+n-2].state}}<br>
              <br>
            <span slot="footer" class="dialog-footer">
            <div align="center">
            <el-button @click="setDialogVisible(n,0)">取 消</el-button>
            <el-button type="primary" :disabled="$store.state.id==tableData[down+n-2].user_id" @click="form.house_id=tableData[down+n-2].house_id,setDialogVisible(n,0),dialogFormVisible=true">我要租</el-button>
            </div>
            </span>
          </span>
        </span>
      </el-dialog>

      <el-dialog
          title="房源信息"
          :visible.sync="dialogVisible10"
          width="30%"
        >
        <span v-for="n in up">
          <span v-if="n === 10">
              <div align="center"><h3>{{tableData[down+n-2].description}}</h3><br></div>
              城市： {{tableData[down+n-2].city_name}}<br>
              街区： {{tableData[down+n-2].community_name}}<br>
              房型： {{tableData[down+n-2].house_type}}<br>
              面积： {{tableData[down+n-2].house_area}}<br>
              楼层： {{tableData[down+n-2].house_floor}}<br>
              电梯： {{tableData[down+n-2].is_elevator}}<br>
              押金： {{tableData[down+n-2].deposit}}<br>
              支付： {{tableData[down+n-2].payment_method}}<br>
              租金： {{tableData[down+n-2].rent_per_month}}<br>
              最近修改时间： {{tableData[down+n-2].modify_time}}<br>
              状态： {{tableData[down+n-2].state}}<br>
              <br>
            <span slot="footer" class="dialog-footer">
            <div align="center">
            <el-button @click="setDialogVisible(n,0)">取 消</el-button>
            <el-button type="primary" :disabled="$store.state.id==tableData[down+n-2].user_id" @click="form.house_id=tableData[down+n-2].house_id,setDialogVisible(n,0),dialogFormVisible=true">我要租</el-button>
            </div>
            </span>
          </span>
        </span>
      </el-dialog>


      <el-dialog title="租住信息" :visible.sync="dialogFormVisible">
        <el-form :model="form">
          <el-form-item label="留言" :label-width="formLabelWidth">
            <el-input v-model="form.description" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="起租时间" :label-width="formLabelWidth">
              <el-date-picker
                v-model="form.start_month"
                type="date"
                placeholder="选择日期"
                value-format=yyyy-MM-dd>
              </el-date-picker>
          </el-form-item>

            <el-form-item label="租住时间(月)" :label-width="formLabelWidth">
              <el-input-number v-model="form.continual_month"  :min="1" :max="100" label=""></el-input-number>
            </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button @click="dialogFormVisible = false">取 消</el-button>
          <el-button type="primary" @click="rentapply(),dialogFormVisible = false">确 定</el-button>
        </div>
      </el-dialog>

     </div>
    </body>
  </html>
</template>





<script>
  export default {
         data() {
      return {
        temp4:'',
        tmp:0,
        phototmp:'',
        houseidtmp:'',
        tableData:[],
        photoData:[],
        length:0,
        mlength:0,
        page:0,
        down:0,
        up:0,
        flip:0,

          options: [{
          value: '-1',
          label: '无'
        },{
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

        hello:'城市：',
        hello2:'街区：',
        hello3:'面积：',
        hello4:'————',
        hello5:'房型：',
        hello6:'是否电梯：',
        hello7:'描述：',
        city:'选择城市',

        city_name: '',
        community_name: '',
        min_area:0,
        max_area:0,
        is_elevator: -1,
        house_type: 0,
        value: '',
        descriptiont: '',

        dialogVisible1: false,
        dialogVisible2: false,
        dialogVisible3: false,
        dialogVisible4: false,
        dialogVisible5: false,
        dialogVisible6: false,
        dialogVisible7: false,
        dialogVisible8: false,
        dialogVisible9: false,
        dialogVisible10: false,
        dialogFormVisible: false,

        form: {
          house_id: 0,
          tenant_user_name: '',
          start_month: '',
          continual_month: 1,
          description: '',
        },
        formLabelWidth: '120px'
      }
    },
    methods: {
      gethouse(){
        while(this.tableData.length!=0)
        this.tableData.pop();
        while(this.photoData.length>0)
        this.photoData.pop();
        let params = new URLSearchParams();
 
        params.append('city_name', '-1');

        params.append('community_name', '-1');

        params.append('house_type', -1);

        params.append('max_house_area', -1);

        params.append('min_house_area', -1);
				params.append('house_num', '-1');
        params.append('house_floor', -1);

         params.append('is_elevator', -1);
        params.append('description', '-1');
        params.append('payment_method', -1);
				params.append('low_rent_per_month', -1);
                params.append('high_rent_per_month', -1);
                params.append('state', -1); 
                console.log(this.community_name);
					this.$axios({                
						method:"post",                           
					url:'http://localhost:8080/RentHouseSystem/house/SelectHouse2',               
					 data:params,                            
					 }).then(res=> {
						
						var tempData=[];
        for(var k=0;k<res.data.length;k++)
        {
          tempData.push(res.data[k]);
        }
        this.length=res.data.length;
        console.log(tempData);
        for(var k=0;k<tempData.length;k++)
        {
        
          var temp={
            house_id:tempData[k].house_id,
            city_name:tempData[k].city_name,
            community_name:tempData[k].community_name,
            house_num:tempData[k].house_num,
            
            house_type:tempData[k].house_type,
            house_area:tempData[k].house_area,
            house_floor:tempData[k].house_floor,
            is_elevator:tempData[k].is_elevator,
            description:tempData[k].description,
            deposit:tempData[k].deposit,
            payment_method:tempData[k].payment_method,
            rent_per_month:tempData[k].rent_per_month,
            modify_time:tempData[k].modify_time,
            state:tempData[k].state,
            user_id:tempData[k].user_id
          }
          if(temp.house_type==1)
          temp.house_type='一居';
          if(temp.house_type==2)
          temp.house_type='二居';
          if(temp.house_type==3)
          temp.house_type='三居';
          if(temp.house_type==4)
          temp.house_type='四居+';
          if(temp.is_elevator==1)
          temp.is_elevator='有';
          if(temp.is_elevator==0)
          temp.is_elevator='无';
          if(temp.payment_method==1)
          temp.payment_method='月';
          if(temp.payment_method==2)
          temp.payment_method='季';
          if(temp.payment_method==3)
          temp.payment_method='年';
          console.log(temp)

            this.tableData.push(temp);


          let params2 = new URLSearchParams();
          params2.append('house_id',this.tableData[k].house_id);
          console.log(params2);
          this.$axios({                
					method:"post",                           
					url:'http://localhost:8080/RentHouseSystem/house/download',               
					data:params2,                            
					}).then(res=> {
          //console.log('res'+res);
          this.tmp=this.tmp+1;
          console.log('resdata0.phptp'+res.data[0].photo);
          console.log('resdata0.house_id'+res.data[0].house_id);
          var ptmp=res.data[0].photo;
          var htmp=res.data[0].house_id;
          console.log('ptmp'+ptmp);
           console.log('htmp'+htmp);
          var temp2={data:ptmp,house_id:htmp};
          this.photoData.push(temp2);
          this.mlength=this.photoData.length;
          });
        }

        console.log(this.tableData);
        this.handleCurrentChange(1);
        this.refresh()
          });
        
      },
      refresh()
      {
        this.flip=1-this.flip;
      },
      handleCurrentChange(val)
      {
        this.down=(val-1)*10+1;
        if(this.down+9>this.length)
          this.up=this.length-this.down+1;
        else
          this.up=10;
        refresh();
      },
      setDialogVisible(num,val)
      {
        if(val==1)
        {
          if(num==1)this.dialogVisible1=true;
          if(num==2)this.dialogVisible2=true;
          if(num==3)this.dialogVisible3=true;
          if(num==4)this.dialogVisible4=true;
          if(num==5)this.dialogVisible5=true;
          if(num==6)this.dialogVisible6=true;
          if(num==7)this.dialogVisible7=true;
          if(num==8)this.dialogVisible8=true;
          if(num==9)this.dialogVisible9=true;
          if(num==10)this.dialogVisible10=true;
        }
        else
        {
          if(num==1)this.dialogVisible1=false;
          if(num==2)this.dialogVisible2=false;
          if(num==3)this.dialogVisible3=false;
          if(num==4)this.dialogVisible4=false;
          if(num==5)this.dialogVisible5=false;
          if(num==6)this.dialogVisible6=false;
          if(num==7)this.dialogVisible7=false;
          if(num==8)this.dialogVisible8=false;
          if(num==9)this.dialogVisible9=false;
          if(num==10)this.dialogVisible10=false;
        }
      },
      onSubmit(){
        this.length=0;
        while(this.tableData.length!=0)
        this.tableData.pop();
        while(this.photoData.length>0)
        this.photoData.pop();
        let params = new URLSearchParams();
        if(this.city_name!='')
        params.append('city_name', this.city_name);
        else
        params.append('city_name', '-1');
        if(this.community_name!='')          
        params.append('community_name', this.community_name);
        else
        params.append('community_name', '-1');
        if(this.house_type!=0)
        params.append('house_type', this.house_type);
        else
        params.append('house_type', -1);
        if(this.max_area!=0)
        params.append('max_house_area', this.max_area);
        else
        params.append('max_house_area', -1);
        if(this.min_area!=0)
        params.append('min_house_area', this.min_area);
        else
        params.append('min_house_area', -1);
				params.append('house_num', '-1');
        params.append('house_floor', -1);
        if(this.is_elevator!=-1)
        params.append('is_elevator', this.is_elevator);
        else
         params.append('is_elevator', -1);
         if(this.descriptiont=='')
        params.append('description', '-1');
        else
        params.append('description', this.descriptiont);
        params.append('payment_method', -1);
				params.append('low_rent_per_month', -1);
                params.append('high_rent_per_month', -1);
        params.append('state', -1); 
                console.log(this.community_name);
					this.$axios({                
						method:"post",                           
					url:'http://localhost:8080/RentHouseSystem/house/SelectHouse2',               
					 data:params,                            
					 }).then(res=> {
						
						var tempData=[];
        for(var k=0;k<res.data.length;k++)
        {
          tempData.push(res.data[k]);
        }
        this.length=res.data.length;
        console.log(tempData);
        for(var k=0;k<tempData.length;k++)
        {
        
          var temp={
            house_id:tempData[k].house_id,
            city_name:tempData[k].city_name,
            community_name:tempData[k].community_name,
            house_num:tempData[k].house_num,
            
            house_type:tempData[k].house_type,
            house_area:tempData[k].house_area,
            house_floor:tempData[k].house_floor,
            is_elevator:tempData[k].is_elevator,
            description:tempData[k].description,
            deposit:tempData[k].deposit,
            payment_method:tempData[k].payment_method,
            rent_per_month:tempData[k].rent_per_month,
            modify_time:tempData[k].modify_time,
            state:tempData[k].state,
            user_id:tempData[k].user_id
          }
          if(temp.house_type==1)
          temp.house_type='一居';
          if(temp.house_type==2)
          temp.house_type='二居';
          if(temp.house_type==3)
          temp.house_type='三居';
          if(temp.house_type==4)
          temp.house_type='四居+';
          if(temp.is_elevator==1)
          temp.is_elevator='有';
          if(temp.is_elevator==0)
          temp.is_elevator='无';
          if(temp.payment_method==1)
          temp.payment_method='月';
          if(temp.payment_method==2)
          temp.payment_method='季';
          if(temp.payment_method==3)
          temp.payment_method='年';
          console.log(temp)

            this.tableData.push(temp);


          let params2 = new URLSearchParams();
          params2.append('house_id',this.tableData[k].house_id);
          console.log(params2);
          this.$axios({                
					method:"post",                           
					url:'http://localhost:8080/RentHouseSystem/house/download',               
					data:params2,                            
					}).then(res=> {
          //console.log('res'+res);
          this.tmp=this.tmp+1;
          console.log('resdata0.phptp'+res.data[0].photo);
          console.log('resdata0.house_id'+res.data[0].house_id);
          var ptmp=res.data[0].photo;
          var htmp=res.data[0].house_id;
          console.log('ptmp'+ptmp);
           console.log('htmp'+htmp);
          var temp2={data:ptmp,house_id:htmp};
          this.photoData.push(temp2);
          this.mlength=this.photoData.length;
          });
          
        }
        console.log(this.tableData);
this.tmp=this.tmp+1;
        this.handleCurrentChange(1);
        this.refresh()
					});
        
      },
              changelink(route){
    this.$router.replace(route);
  },
      //public int AddWant(int house_id, String tenant_user_name, int start_month, int continual_month, String description)
      rentapply()
      {
        let param=new URLSearchParams();
        param.append('house_id',this.form.house_id);
        param.append('tenant_user_name',this.$store.state.account);
        param.append('start_month',this.form.start_month);
        param.append('continual_month',this.form.continual_month);
        param.append('description',this.form.description);
        console.log(param);
        this.$axios({                
					method:"post",                           
					url:'http://localhost:8080/RentHouseSystem/want/AddWant',               
					data:param,                            
					}).then(res=> {
          console.log(res);
            if(res.data>0)
            {
              this.$message({
              showClose: true,
              message: '租房申请已发送',
              type: 'success',
              center: true
              });
            }
            else
            {
              this.$message({
              showClose: true,
              message: '租房申请发送失败',
              type: 'error',
              center: true
              });
            }
          });
        
      }
    },

        	mounted(){
      this.gethouse();
		}
  }
  


</script>
