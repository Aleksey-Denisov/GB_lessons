using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using WinFormsApp1.model;
using WinFormsApp1.service;

namespace WinFormsApp1.controller
{
    internal class DeliveryController
    {
        private DeliveryAction action;
        public void delivery(DeliveryEnum type)
        {
            action = DeliveryBuild.getTransport(type);
        }
        public String getTransport()
        {
            return ((DeliveryGet)action).getTransport();
        }
        public String receivingAnOrder()
        {
            return action.receivingAnOrder();
        }
        public String deliveryOrder()
        {
            return action.deliveryOrder();
        }
        public String deliveryComplite()
        {
            return "Доставка выполнена";
        }
    }
}
