import Home from './components/HelloWorld.vue'
import Calendar from './components/children/Calendar.vue'
import adddemand from './components/children/adddemand.vue'
import information from './components/children/information.vue'
import reference from './components/children/reference.vue'
import mydemand from './components/children/mydemand.vue'
import user_information from './components/user_information.vue'
import register from './components/children/register.vue'
import income from './components/children/income.vue'
import house_manage from './components/children/house_manage.vue'
import user_manage from './components/children/user_manage.vue'
import manage2 from './components/children/manage2.vue'
import manage3 from './components/children/manage3.vue'
import house_now from './components/children/house_now.vue'
import demand_now from './components/children/demand_now.vue'
import rent_now from './components/children/rent_now.vue'
import myhouse from './components/children/myhouse.vue'
import addphoto from './components/children/addphoto.vue'
import showphoto from './components/children/showphoto.vue'
import photowall from './components/children/photowall.vue'
import rent_apply from './components/children/rent_apply.vue'
import uncomplete from './components/children/uncomplete.vue'
import unaffirm from './components/children/unaffirm.vue'
import have_done from './components/children/have_done.vue'
import have_done2 from './components/children/have_done2.vue'
import pay from './components/children/pay.vue'
import message from './components/children/message.vue'
const routers = 
[
  {
    path: '/',
    component: Home,
  },
  {
    path: '/home',
    name: 'home',
    component: Home,
  },
  {
    path: '/Calendar',
    name: 'calendar',
    component: Calendar,
  },

  {
    path: '/adddemand',
    name: 'adddemand',
    component: adddemand
  },
  {
    path: '/information',
    name: 'information',
    component: information
  },
  {
    path: '/reference',
    name: 'reference',
    component: reference,
  },
  {
    path: '/mydemand',
    name: 'mydemand',
    component: mydemand,
  },
  {
    path: '/register',
    name: 'register',
    component: register,
  },
  {
    path: '/user_information',
    name: 'user_information',
    component: user_information,
  },
  {
    path: '/income',
    name: 'income',
    component: income,
  },
  {
    path: '/have_done',
    name: 'have_done',
    component: have_done,
  },
  {
    path: '/have_done2',
    name: 'have_done2',
    component: have_done2,
  },
  {
    path: '/house_manage',
    name: 'house_manage',
    component: house_manage,
  },
  {
    path: '/manage2',
    name: 'manage2',
    component: manage2,
  },
  {
    path: '/manage3',
    name: 'manage3',
    component: manage3,
  },
  {
    path: '/user_manage',
    name: 'user_manage',
    component: user_manage,
  },
  {
    path: '/house_now',
    name: 'house_now',
    component: house_now,
  },
  {
    path: '/demand_now',
    name: 'demand_now',
    component: demand_now,
  },
  {
    path: '/rent_now',
    name: 'rent_now',
    component: rent_now,
  },
  {
    path: '/myhouse',
    name: 'myhouse',
    component: myhouse,
  },
  {
    path: '/addphoto',
    name: 'addphoto',
    component: addphoto,
  },
  {
    path: '/showphoto',
    name: 'showphoto',
    component: showphoto,
  },
  {
    path: '/photowall',
    name: 'photowall',
    component: photowall,
  },
  {
    path: '/rent_apply',
    name: 'rent_apply',
    component: rent_apply,
  },
  {
    path: '/uncomplete',
    name: 'uncomplete',
    component: uncomplete,
  },
  {
    path: '/unaffirm',
    name: 'unaffirm',
    component: unaffirm,
  },
  {
    path: '/pay',
    name: 'pay',
    component: pay,
  },
  {
    path: '/message',
    name: 'message',
    component: message,
  },
]

export default routers
