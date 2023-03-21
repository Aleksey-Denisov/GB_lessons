using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using WinFormsApp1.service;

namespace WinFormsApp1.model
{
    internal class DeliveryBuild
    {
        public static DeliveryAction getTransport(DeliveryEnum type)
        {
            DeliveryAction action = null;
            switch (type)
            {
                case DeliveryEnum.BIKE:
                    action = new Bike();
                    break;
                case DeliveryEnum.ELECTRICSCOOTER:
                    action = new ElectricScooter();
                    break;
                case DeliveryEnum.FOOTS:
                    action = new Foots();
                    break;
                case DeliveryEnum.QUADCOPTER:
                    action = new QuadCopter();
                    break;
                default:
                    break;
            }
            return action;
        }
    }
}
