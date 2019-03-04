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
          <h1>租房申请</h1> 
      </div>
      <div>
        </div>
  </el-col>
</el-row>
		<el-dialog title="租房人信息" :visible.sync="editFormVisible3" :close-on-click-modal="true" :label-position="right">

			<el-form :model="editForm3" label-width="300px" :rules="editFormRules" ref="editForm">

				<el-form-item  label="账号" prop="name">

					<p >{{editForm3.user_name}}</p>

				</el-form-item>

				<el-form-item label="电话号">

					<p>{{editForm3.mobile_num}}</p>

				</el-form-item>

				<el-form-item label="等级">

					<p>{{editForm3.user_level}}</p>

				</el-form-item>
			</el-form>

			<div slot="footer" class="dialog-footer">

				<el-button @click.native="editFormVisible = false">关闭</el-button>

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
      prop="real_name"
      label="姓名"
      width="120">
    </el-table-column>
            <el-table-column
      prop="modify_time"
      label="时间"
      width="120">
    </el-table-column>
            <el-table-column
      fixed="right"
      label="租房人信息"
      width="120">
      <template slot-scope="scope">
        <el-button
          size="mini"
          type="success"
          @click.native.prevent="spy(scope.$index, scope.row,tableData)">查看</el-button>
      </template>
    </el-table-column>
        <el-table-column
      fixed="right"
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
      fixed="right"
      label="操作"
      width="200">
      <template slot-scope="scope">
        <el-button
          size="mini"
          type="danger"
          @click.native.prevent="delet(scope.$index, scope.row,tableData)">拒绝</el-button>
        <el-button
          size="mini"
          type="success"
          @click.native.prevent="agree(scope.$index, scope.row,tableData)">同意</el-button>
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
.el-form-item-label{
    font-size:20px;
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
        editForm3:{
          user_name:'',
          mobile_num:'',
          user_level:'',

        },
        editFormVisible:false,
        editFormVisible3:false,
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
              this.$message({message: '拒绝成功！',type: 'success'});
              this.tableData.splice(index, 1);
            }})
      },
      getwant(){
          let params = new URLSearchParams();
          params.append('user_id', this.$store.state.id);
					this.$axios({                
						method:"post",                           
					url:'http://localhost:8080/RentHouseSystem/want/SelectWantByLandlordUserId',               
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
          {
            this.tableData.push(temp);
        }
        console.log(this.tableData);
        }
        })
			
  },
   spy(index, row,tableData) {
      this.editFormVisible3 = true;
          let params = new URLSearchParams();
          params.append('user_id', row.tenant_user_id);
					this.$axios({                
						method:"post",                           
					url:'http://localhost:8080/RentHouseSystem/user/FindUserByUserId',               
					 data:params,                            
					 }).then(res=> {
          this.editForm3.user_name=res.data.user_name;
          this.editForm3.mobile_num=res.data.mobile_num;
          this.editForm3.user_level=res.data.user_level;
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
      agree(index,row,tableData)
      {
          console.log(row);
          let params = new URLSearchParams();
				params.append('want_id', row.want_id);
					this.$axios({                
						method:"post",                           
			  		url:'http://localhost:8080/RentHouseSystem/want/Want2Agree',               
					 data:params,                            
					 }).then(res=> {
            if(res.data==1)
            {
              this.$message({message: '已同意租房请求！',type: 'success'});
               tableData.splice(index, 1);
            }
           })
      },
      editSubmit(){
        let params = new URLSearchParams();
				params.append('rent_id', this.editForm.erent_id);
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
     
    },
        	mounted(){
			this.getwant()
		}
  }
</script>