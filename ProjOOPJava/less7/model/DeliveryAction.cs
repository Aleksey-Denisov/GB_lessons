using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace WinFormsApp1.model
{
    internal class DeliveryAction
    {
        public String receivingAnOrder()
        {
            return "Получил заказ";
        }
        public String deliveryOrder()
        {
            return "Заказ в доставке";
        }
    }
    abstract class DeliveryGet : DeliveryAction
    {

        public abstract String getTransport();
    }
    class Bike : DeliveryGet
    {
        public override String getTransport()
        {
            return "Доставка выполняется на велосипеде";
        }
    }
    class ElectricScooter : DeliveryGet
    {
        public override String getTransport()
        {
            return "Доставка выполняется на электро самокате";
        }
    }
    class Foots : DeliveryGet
    {
        public override String getTransport()
        {
            return "Доставка выполняется пешком";
        }
    }
    class QuadCopter : DeliveryGet
    {
        public override String getTransport()
        {
            return "Доставка выполняется квадрокоптером";
        }
    }
}
