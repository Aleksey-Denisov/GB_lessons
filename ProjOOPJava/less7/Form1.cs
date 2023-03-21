using System.Windows.Forms;
using WinFormsApp1.controller;
using WinFormsApp1.service;
using static System.Windows.Forms.VisualStyles.VisualStyleElement;

namespace WinFormsApp1
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }


        private void button1_Click(object sender, EventArgs e)
        {
            //richTextBox1.AppendText(textBox1.Text);
            if (textBox1.Text != "")
            {
                richTextBox1.Text = textBox1.Text;
            }
        }

        private void button2_Click(object sender, EventArgs e)
        {
            if (textBox1.Text == "" || textBox1.Text == "Доставка выполнена")
            {
                MessageBox.Show("В данный момент заказов нет");
                textBox1.Text = "";
                return;
            }
            else if (comboBox1.SelectedIndex == -1)
            {
                MessageBox.Show("Необходимо выбрать вариант из списка");
                return;
            }
            else
            {
                DeliveryController controller = new DeliveryController();
                controller.delivery((DeliveryEnum)comboBox1.SelectedIndex);
                richTextBox1.Text = textBox1.Text + "\n" + controller.getTransport() + "\n" + controller.receivingAnOrder() + "\n"
                    + controller.deliveryOrder() + "\n" + controller.deliveryComplite();
                textBox1.Text = controller.deliveryComplite();
            }
        }
    }
}