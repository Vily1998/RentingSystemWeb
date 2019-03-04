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
          <h1>未确认订单</h1> 
      </div>
      <div>
        
        </div>
  </el-col>
</el-row>
<el-dialog title="编辑" :visible.sync="editFormVisible2" :close-on-click-modal="true">

			<el-form :model="editForm2" label-width="80px" :rules="editFormRules" ref="editForm">

				
        	<el-form-item label="开始月份">

					    <el-date-picker
      v-model="editForm2.start_month"
      type="date"
             format="yyyy 年 MM 月 dd 日"
       value-format="yyyy-MM-dd"
      placeholder="选择日期"
      >
    </el-date-picker>

				</el-form-item>
          <el-form-item label="持续月份">

					<el-input-number v-model="editForm2.continual_month" auto-complete="off"></el-input-number>

				</el-form-item>

				<el-form-item label="描述">

					<el-input type="textarea" v-model="editForm2.description"></el-input>

				</el-form-item>

			</el-form>

			<div slot="footer" class="dialog-footer">

				<el-button @click.native="editFormVisible = false">取消</el-button>

				<el-button type="primary" @click.native="editSubmit" >提交      </el-button>

			</div>

		</el-dialog>
		<el-dialog title="房屋信息" :visible.sync="editFormVisible" :close-on-click-modal="true" :label-position="right">

			<el-form :model="editForm" label-width="300px" :rules="editFormRules" ref="editForm">

				<el-form-item  label="城市" prop="name">

					<p >{{editForm.ecity_name}}</p>

				</el-form-item>

				<el-form-item label="街区">

					<p>{{editForm.ecommunity_name}}</p>

				</el-form-item>

				<el-form-item label="门牌号">

					<p>{{editForm.ehouse_num}}</p>

				</el-form-item>

				<el-form-item label="房型">

                <p>{{editForm.ehouse_type}}</p>

				</el-form-item>
        		<el-form-item label="面积" prop="name">

					<p>{{editForm.ehouse_area}}</p>

				</el-form-item>

				<el-form-item label="楼层">

                <p>{{editForm.ehouse_floor}}</p>
				</el-form-item>

				<el-form-item label="是否有电梯">

                <p>{{editForm.eis_elevator}}</p>

				</el-form-item>

				<el-form-item label="描述">

			    <p>{{editForm.edescription}}</p>

				</el-form-item>
        		<el-form-item label="押金" prop="name">

				<p>{{editForm.edeposit}}</p>

				</el-form-item>

				<el-form-item label="支付方式">

                <p>{{editForm.epayment_method}}</p>

				</el-form-item>

				<el-form-item label="月租金">

				<p>{{editForm.edeposit}}</p>

				</el-form-item>

			</el-form>

			<div slot="footer" class="dialog-footer">

				<el-button @click.native="editFormVisible = false">关闭</el-button>

			</div>

		</el-dialog>
      <el-table
    :data="tableData"
    border
    style="width: 100%">
        <el-table-column
      prop="start_month"
      label="开始月份"
      sortable
      width="120">
    </el-table-column>
    <el-table-column
      prop="continual_month"
      label="租住月数"
      sortable
      width="120">
    </el-table-column>
        <el-table-column
      prop="description"
      label="描述"
      width="400">
    </el-table-column>
            <el-table-column
      label="删除"
      width="120">
      <template slot-scope="scope">
        <el-button
          size="mini"
          type="danger"
          @click.native.prevent="delet(scope.$index, scope.row,tableData)">删除</el-button>
      </template>
    </el-table-column>
        <el-table-column
      label="房屋信息"
      width="120">
      <template slot-scope="scope">
        <el-button
          size="mini"
          type="success"
          @click.native.prevent="look(scope.$index, scope.row,tableData)">查看</el-button>
      </template>
    </el-table-column>

    <el-table-column
      label="操作"
      width="120">
      <template slot-scope="scope">
        <el-button
          size="mini"
          type="success"
          @click.native.prevent="handleEdit(scope.$index, scope.row,tableData)">修改</el-button>
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
        editForm2:{
        start_month:0,
        continual_month:0,
         description:'',
        },
        editFormVisible2:false,
        editFormVisible:false,
        eindex:0,
      
      }
    },
    methods: {
      delet(index, row,tableData){
           let params = new URLSearchParams();
        params.append('want_id', row.want_id);
        this.$axios({                
						method:"post",                           
					url:'http://localhost:8080/RentHouseSystem/want/DeleteWant',               
					 data:params,                            
					 }).then(res=> {
						let resultjson=res.data;
						console.log(resultjson);
						if (resultjson!=0) {
              this.$message({message: '删除成功！',type: 'success'});
              this.tableData.splice(index, 1);
            }})
      },
 getwant(){
          let params = new URLSearchParams();
          params.append('user_id', this.$store.state.id);
					this.$axios({                
						method:"post",                           
					url:'http://localhost:8080/RentHouseSystem/want/SelectWantByTenantUserId',               
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
        want_id:res.data[k].want_id,
        landlord_user_id:res.data[k].landlord_user_id,
        house_id:res.data[k].house_id,
        tenant_user_id:res.data[k].tenant_user_id,
         real_name:res.data[k].real_name,
        start_month:res.data[k].start_month,
        continual_month:res.data[k].continual_month,
         description:res.data[k].description,
         modify_time:res.data[k].modify_time,
         state:res.data[k].state,
          }
          console.log(temp)
          if(temp.state==1)
          this.tableData.push(temp);
        }
        console.log(this.tableData);
					})
			
  },
          look(index, row,tableData) {
        console.log(index, row);

        this.editFormVisible = true;
        console.log(this.editFormVisible);
        let params = new URLSearchParams();
				params.append('house_id', row.house_id);
					this.$axios({                
						method:"post",                           
			  		url:'http://localhost:8080/RentHouseSystem/house/SelectHouseByHouseId',               
					 data:params,                            
					 }).then(res=> {
						let resultjson=res.data;
						console.log(resultjson);
            this.editForm.ehouse_id=resultjson.house_id;
            this.editForm.ecity_name=resultjson.city_name;
            this.editForm.ecommunity_name=resultjson.community_name;
            this.editForm.ehouse_num=resultjson.house_num;
            this.editForm.ehouse_type=resultjson.house_type;
            this.editForm.ehouse_area=resultjson.house_area;
            this.editForm.ehouse_floor=resultjson.house_floor;
            this.editForm.eis_elevator=resultjson.is_elevator;
            this.editForm.edescription=resultjson.description;
            this.editForm.edeposit=resultjson.deposit;
            this.editForm.epayment_method=resultjson.payment_method;
            this.editForm.erent_per_month=resultjson.rent_per_month;
            this.editForm.modify_time=resultjson.modify_time;
            this.editForm.estate=resultjson.state;
            this.eindex=index;
          if(this.editForm.ehouse_type==1)
          this.editForm.ehouse_type='一居';
          if(this.editForm.ehouse_type==2)
          this.editForm.ehouse_type='二居';
          if(this.editForm.ehouse_type==3)
          this.editForm.ehouse_type='三居';
          if(this.editForm.ehouse_type==4)
          this.editForm.ehouse_type='四居+';
          if(this.editForm.eis_elevator==1)
          this.editForm.eis_elevator='有';
          if(this.editForm.eis_elevator==0)
          this.editForm.eis_elevator='无';
          if(this.editForm.epayment_method==1)
          this.editForm.epayment_method='月';
          if(this.editForm.epayment_method==2)
          this.editForm.epayment_method='季';
          if(this.editForm.epayment_method==3)
          this.editForm.epayment_method='年';
          if(this.editForm.estate==1)
          this.editForm.estate='已出租';
          if(this.editForm.estate==0)
          this.editForm.estate='未出租';
        
        console.log(this.tableData);
					
            
           })
      },
        handleEdit(index, row,tableData) {
        console.log(index, row);
        this.eindex=index;
        this.editForm2.start_month=row.start_month;
        this.editForm2.continual_month=row.continual_month;
        this.editForm2.description=row.description;
        this.editForm2.want_id=row.want_id;
        this.editForm2.landlord_user_id=row.landlord_user_id,
        this.editForm2.house_id=row.house_id,
        this.editForm2.tenant_user_id=row.tenant_user_id,
        this.editForm2.real_name=row.real_name,
        this.editForm2.modify_time=row.modify_time,
        this.editForm2.state=row.state,
        this.editFormVisible2 = true;
        console.log(this.editFormVisible);


      },
      editSubmit(){
          let params = new URLSearchParams();
				params.append('want_id', this.editForm2.want_id);
				params.append('start_month', this.editForm2.start_month);
				params.append('continual_month', this.editForm2.continual_month);
				params.append('description', this.editForm2.description);
					this.$axios({                
						method:"post",                           
					url:'http://localhost:8080/RentHouseSystem/want/UpdateWant',               
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
				 want_id:this.editForm2.want_id,
				 start_month:this.editForm2.start_month,
				 continual_month:this.editForm2.continual_month,
         description:this.editForm2.description,
        landlord_user_id:this.editForm2.landlord_user_id,
        house_id:this.editForm2.house_id,
        tenant_user_id:this.editForm2.tenant_user_id,
         real_name:this.editForm2.real_name,
         modify_time:this.editForm2.modify_time,
         state:this.editForm2.state,
         
          }

              this.tableData.push(temp);
              
						}else{
							//this.$message({message: '注册失败！',type: 'success'});
							this.$message.error('更新失败,网络异常！');
							//window.alert('注册失败,服务器错误,请重试！');
						}
					})
      },

    },
        	mounted(){
			this.getwant()
		}
  }
</script>