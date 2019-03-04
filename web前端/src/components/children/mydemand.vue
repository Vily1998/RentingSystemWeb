<template>
<html>
<el-row>
  <el-col :span="1">
      <div>
        <router-link to = "/myhouse"><el-button><i class="el-icon-caret-left"></i> </el-button></router-link>
      </div>
  </el-col>
  <el-col :span="21">
      <div>
          <h1>我的需求</h1> 
      </div>
      <div>
        
        </div>
  </el-col>
</el-row>
   <el-dialog title="编辑" :visible.sync="editFormVisible" :close-on-click-modal="true">

			<el-form :model="editForm" label-width="80px" :rules="editFormRules" ref="editForm">

				<el-form-item label="城市" prop="name">

					<el-input v-model="editForm.ecity_name" auto-complete="off"></el-input>

				</el-form-item>

				<el-form-item label="街区">

					<el-input v-model="editForm.ecommunity_name"></el-input>

				</el-form-item>



				<el-form-item label="房型">

					    <el-radio-group v-model="editForm.ehouse_type" id='s1' >
      <el-radio :label="1">一居</el-radio>
      <el-radio :label="2">两居</el-radio>
      <el-radio :label="3">三居</el-radio>
      <el-radio :label="4">四居+</el-radio>
    </el-radio-group>

				</el-form-item>
        			

				<el-form-item label="楼层">

					<el-input-number v-model="editForm.ehouse_floor"></el-input-number>

				</el-form-item>

				<el-form-item label="是否有电梯">

				<el-radio-group v-model="editForm.eis_elevator" id='s2' >
      <el-radio :label="1">是</el-radio>
      <el-radio :label="0">否</el-radio>
    </el-radio-group>

				</el-form-item>

				<el-form-item label="描述">

					<el-input type="textarea" v-model="editForm.edescription"></el-input>

				</el-form-item>
        				<el-form-item label="押金" prop="name">

					<el-input-number v-model="editForm.edeposit" auto-complete="off"></el-input-number>

				</el-form-item>

				<el-form-item label="支付方式">

				<el-radio-group v-model="editForm.epayment_method" id='s3' >
      <el-radio :label="1">月</el-radio>
      <el-radio :label="2">季</el-radio>
      <el-radio :label="3">年</el-radio>
    </el-radio-group>

				</el-form-item>

				<el-form-item label="月租金">

					<el-input-number v-model="editForm.erent_per_month"></el-input-number>

				</el-form-item>

			</el-form>

			<div slot="footer" class="dialog-footer">

				<el-button @click.native="editFormVisible = false">取消</el-button>

				<el-button type="primary" @click.native="editSubmit" >提交      </el-button>

			</div>

		</el-dialog>

      <el-table
    :data="tableData"
    border
    style="width: 100%">
    <el-table-column
      prop="city_name"
      label="城市"
      width="150">
    </el-table-column>
    <el-table-column
      prop="community_name"
      label="街区"
      width="120">
    </el-table-column>
    <el-table-column
      prop="house_type"
      label="房型"
      width="120">
    </el-table-column>
    <el-table-column
      prop="house_floor"
      label="楼层"
      width="120">
    </el-table-column>
        <el-table-column
      prop="is_elevator"
      label="是否有电梯"
      width="120">
    </el-table-column>
        <el-table-column
      prop="description"
      label="描述"
      width="120">
    </el-table-column>
        <el-table-column
      prop="deposit"
      label="押金"
      sortable
      width="120">
    </el-table-column>
        <el-table-column
      prop="payment_method"
      label="支付方式"
      width="120">
    </el-table-column>
    <el-table-column
      prop="rent_per_month"
      label="月租金"
      sortable
      width="120">
    </el-table-column>
        <el-table-column
      prop="modify_time"
      label="最近修改时间"
      sortable
      width="120">
    </el-table-column>
    <el-table-column
      fixed="right"
      label="操作"
      width="120">
      <template slot-scope="scope">
        <el-button
          @click.native.prevent=" handleEdit(scope.$index,scope.row,tableData)"
          type="text"
          size="small">
          编辑
        </el-button>
        <el-button
          size="mini"
          type="danger"
          @click.native.prevent="handleDelete(scope.$index, scope.row,tableData)">删除</el-button>
      </template>
    </el-table-column>
  </el-table>


</html>
</template>
<style scoped>
    .el-row{
        background:white
    }
      .el-col {
	text-decoration: none;
	font-size: 15px;
}
</style>
<script>
  export default {
   data() {
      return {
        tableData:[],
        

				editForm: {
          erent_id:0,
            ecity_name:'',
            ecommunity_name:'',
            ehouse_type:0,
            ehouse_floor:0,
            eis_elevator:0,
            edescription:'',
            edeposit:0,
            epayment_method:0,
            erent_per_month:0,
            emodify_time:'',

        },
        editFormVisible:false,
        eindex:0,
      
      }
    },
    methods: {
      getrent(){
        let params = new URLSearchParams();
                    params.append('user_id', this.$store.state.id);
					this.$axios({                
						method:"post",                           
					url:'http://localhost:8080/RentHouseSystem/rent/SelectRentByUserId',               
					 data:params,                            
					 }).then(res=> {
						
						var tempData=[];
        for(var k=0;k<res.data.length;k++)
        {
          tempData.push(res.data[k]);
        }
        console.log(tempData);
        for(var k=0;k<tempData.length;k++)
        {
          var temp={
            rent_id:tempData[k].rent_id,
            city_name:tempData[k].city_name,
            community_name:tempData[k].community_name,
            house_type:tempData[k].house_type,
            house_floor:tempData[k].house_floor,
            is_elevator:tempData[k].is_elevator,
            description:tempData[k].description,
            deposit:tempData[k].deposit,
            payment_method:tempData[k].payment_method,
            rent_per_month:tempData[k].rent_per_month,
            modify_time:tempData[k].modify_time,
          }
          console.log(temp)
          if(temp.city_name==-1)
          temp.city_name='任意';
          if(temp.community_name==-1)
          temp.community_name='任意';
          if(temp.house_floor==-1)
          temp.house_floor='任意';
          if(temp.deposit==-1)
          temp.deposit='任意';
          if(temp.rent_per_month==-1)
          temp.rent_per_month='任意';
         if(temp.house_type==-1)
          temp.house_type='任意';
          if(temp.house_type==1)
          temp.house_type='一居';
          if(temp.house_type==2)
          temp.house_type='二居';
          if(temp.house_type==3)
          temp.house_type='三居';
          if(temp.house_type==4)
          temp.house_type='四居+';
          if(temp.is_elevator==-1)
          temp.is_elevator='任意';
          if(temp.is_elevator==1)
          temp.is_elevator='有';
          if(temp.is_elevator==0)
          temp.is_elevator='无';
          if(temp.payment_method==-1)
          temp.payment_method='任意';
          if(temp.payment_method==1)
          temp.payment_method='月';
          if(temp.payment_method==2)
          temp.payment_method='季';
          if(temp.payment_method==3)
          temp.payment_method='年';

          this.tableData.push(temp);
        }
        console.log(this.tableData);
					})
			
  },
        handleEdit(index, row,tableData) {
        console.log(index, row);

        this.editFormVisible = true;
        console.log(this.editFormVisible);

            this.editForm.erent_id=row.rent_id;
            this.editForm.ecity_name=row.city_name;
            this.editForm.ecommunity_name=row.community_name;
            this.editForm.ehouse_num=row.house_num;
            this.editForm.ehouse_type=row.house_type;
            this.editForm.ehouse_area=row.house_area;
            this.editForm.ehouse_floor=row.house_floor;
            this.editForm.eis_elevator=row.is_elevator;
            this.editForm.edescription=row.description;
            this.editForm.edeposit=row.deposit;
            this.editForm.epayment_method=row.payment_method;
            this.editForm.erent_per_month=row.rent_per_month;
            this.editForm.modify_time=row.modify_time;
            this.editForm.estate=row.state;
            this.eindex=index;
                      if(this.editForm.ehouse_type=='一居')
          this.editForm.ehouse_type=1;
          if(this.editForm.ehouse_type=='二居')
          this.editForm.ehouse_type=2;
          if(this.editForm.ehouse_type=='三居')
          this.editForm.ehouse_type=3;
          if(this.editForm.ehouse_type=='四居+')
          this.editForm.ehouse_type=4;
          if(this.editForm.eis_elevator=='有')
          this.editForm.eis_elevator=1;
          if(this.editForm.eis_elevator=='无')
          this.editForm.eis_elevator=0;
          if(this.editForm.epayment_method=='月')
          this.editForm.epayment_method=1;
          if(this.editForm.epayment_method=='季')
          this.editForm.epayment_method=2;
          if(this.editForm.epayment_method=='年')
          this.editForm.epayment_method=3;
          if(this.editForm.estate=='已出租')
          this.editForm.estate=1;
          if(this.editForm.estate=='未出租')
          this.editForm.estate=0;
          if(this.editForm.ehouse_floor=='任意')
          this.editForm.ehouse_floor=-1;
          if(this.editForm.edeposit=='任意')
          this.editForm.edeposit=-1;
          if(this.editForm.erent_per_month=='任意')
          this.editForm.erent_per_month=-1;
          if(this.editForm.ehouse_type=='任意')
          this.editForm.ehouse_type=-1;
          if(this.editForm.eis_elevator=='任意')
          this.editForm.eis_elevator=-1;
          if(this.editForm.epayment_method=='任意')
          this.editForm.epayment_method=-1;
      },
      editSubmit(){
let params = new URLSearchParams();
				params.append('rent_id', this.editForm.erent_id);
				params.append('city_name', this.editForm.ecity_name);
				params.append('community_name', this.editForm.ecommunity_name);
				params.append('house_type', this.editForm.ehouse_type);
        params.append('house_floor', this.editForm.ehouse_floor);
        params.append('is_elevator', this.editForm.eis_elevator);
        params.append('description', this.editForm.edescription);
        params.append('deposit', this.editForm.edeposit);
        params.append('payment_method', this.editForm.epayment_method);
				params.append('rent_per_month', this.editForm.erent_per_month);
					this.$axios({                
						method:"post",                           
					url:'http://localhost:8080/RentHouseSystem/rent/UpdateRent',               
					 data:params,                            
					 }).then(res=> {
						let resultjson=res.data;
						console.log(resultjson);
						if (resultjson.code!=0) {
              this.$message({message: '更新成功！',type: 'success'});
              this.editFormVisible=false;
							//window.alert('注册成功,赶快登陆吧！');
              console.log('h'+this.eindex);
              this.tableData.splice(this.eindex, 1);
              var temp={
            rent:this.editForm.erent_id,
            city_name:this.editForm.ecity_name,
            community_name:this.editForm.ecommunity_name,
            house_type:this.editForm.ehouse_type,
            house_floor:this.editForm.ehouse_floor,
            is_elevator:this.editForm.eis_elevator,
            description:this.editForm.edescription,
            deposit:this.editForm.edeposit,
            payment_method:this.editForm.epayment_method,
            rent_per_month:this.editForm.erent_per_month,
            modify_time:this.editForm.emodify_time,
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
          if(temp.state==1)
          temp.state='已出租';
          if(temp.state==0)
          temp.state='未出租';
          if(temp.house_floor==-1)
          temp.house_floor='任意';
          if(temp.deposit==-1)
          temp.deposit='任意';
          if(temp.rent_per_month==-1)
          temp.rent_per_month='任意';
          if(temp.house_type==-1)
          temp.house_type='任意';
          if(temp.is_elevator==-1)
          temp.is_elevator='任意';
          if(temp.payment_method==-1)
          temp.payment_method='任意';
              this.tableData.push(temp);
						}else{
							//this.$message({message: '注册失败！',type: 'success'});
							this.$message.error('更新失败,网络异常！');
							//window.alert('注册失败,服务器错误,请重试！');
						}
					})
      },
      handleDelete(index, row,tableData) {
        console.log(index, row);
        console.log(tableData);
        let params = new URLSearchParams();
        params.append('rent_id', row.rent_id);
        this.$axios({                
						method:"post",                           
					url:'http://localhost:8080/RentHouseSystem/rent/DeleteRent',               
					 data:params,                            
					 }).then(res=> {
                         let resultjson=res.data;
						console.log(resultjson);
						if (resultjson==1) {
							this.$message({message: '删除成功',type: 'success'});
							 tableData.splice(index, 1);
        
							
						}else if(resultjson==0){
							
							this.$message.error('删除失败');
							
						}

      })
      }
    },
        	mounted(){
			this.getrent()
		}
  }
</script>