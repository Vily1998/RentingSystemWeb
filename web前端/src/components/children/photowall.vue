<template>
<html>
<div>
          <el-menu
            :default-active="activeIndex2"
            class="el-menu-demo"
            mode="horizontal"
            @select="handleSelect"
            background-color="#00B8EC"
            text-color="#fff"
            active-text-color="#ffd04b">
            <el-menu-item index="1" @click="changelink(url)">返回</el-menu-item>
          </el-menu>
</div>
    <div class="info" style="text-align: center;">
      <h1><el-card class="grid-content bg-purple-light" >这是这间房屋的照片</el-card></h1>
      
<div id="app">
    <div class="img-list">
        <img :src="img.url" alt="" v-for="img in fileList" :url="img.url" >
          </div>
      </div>
    </div>

				
				
  </html>
  </template>
  <script>
  export default {
    data () {
      return {
        img_list:[],
        id:0,
        dialogImageUrl:'',
        dialogVisible: false,
        fileList:[],
        visible:true,
      }
    },
    methods: {
      up(){
        this.visible=true;
      },
        submitUpload() {
        this.$refs.upload.submit();
      },

              changelink(route){
    this.$router.replace(route);
  },
         getParams () {
this.id = this.$router.history.current.query.house_id;
this.type = this.$router.history.current.query.type;
if(this.type==1)
this.url="/information";
else
this.url="/Calendar"
console.log(this.id);

      },
      getphoto(){
         let params = new URLSearchParams();
         params.append("house_id",this.id);
         this.$axios({                
						method:"post",                           
					url:'http://localhost:8080/RentHouseSystem/house/download',               
					 data:params,                            
					 }).then(res=> {
                         console.log(this.img_List);
                         for(var k=0;k<res.data.length;k++)
                        {   var temp={
                                        name:'pic'+k,
                                        url:res.data[k].photo,
                                      }
                            this.fileList.push(temp);
                         }
                         console.log(this.fileList);

                     })
      },
      handleRemove(file, fileList) {

          console.log(file,this.fileList);
          let params = new URLSearchParams();
        params.append('photo', file.url);
            this.$axios({                
						method:"post",                           
					url:'http://localhost:8080/RentHouseSystem/house/DeletePhoto',               
                     data:params,           
					 }).then(res => {
                        if(res.data!=null)
                        {
                         this.$message({message: '删除成功！',type: 'success'});
                          var i = this.fileList.length;
                          console.log(i);
                          while (i--) {
                          if (this.fileList[i] === file) {
                            console.log(i);
                          this.fileList.splice(i,1);
                            }
                            console.log(this.fileList);
                         }  
                        }
                        else
                        {
                        return false;
                        }
              })
      },
      handlePictureCardPreview(file) {
        this.dialogImageUrl = file.url;
        this.dialogVisible = true;
      },
      handlePicture(file){
           console.log(1);
          let formdata = new FormData();
          console.log(this.id);
          formdata.append('house_id',this.id);
          formdata.append('file',file);
          let config = {            
            headers: {'Content-Type': 'multipart/form-data'}
            };

          
            this.$axios({                
						method:"post",                           
					url:'http://localhost:8080/RentHouseSystem/house/upload',               
                     data:formdata,             
              config:config,
					 }).then(res => {
                        if(res.data)
                        {
                          
                          var k=Math.ceil(Math.random()*10000);
                                       var temp={
                                        name:'pic'+k,
                                        url:res.data,
                                      }
                            this.fileList.push(temp);
                            console.log(this.fileList);
                            this.$message({message: '添加成功！',type: 'success'});
                        }
                        else
                        return false;
              })  
      },
    
    },
    	mounted(){
            this.getParams();
            this.getphoto();
        }
        
  }
  </script>
  
  <style  scoped>
 #logon{
	position : absolute;
	left:750px;
  top:500px;
  }
        #app {
        text-align: center;
        margin:50px auto;
        width: 800px;
      }
        #app .img-list {
        margin-top:20px;
      }

      #app .img-list img {
        float: left;
        width: 180px;
        height:180px;
        margin:8px;
        display: block;
        border:1px solid #e0e0e0;
        border-radius: 3px;
      }
  </style>
  