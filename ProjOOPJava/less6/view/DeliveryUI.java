package ProjOOPJava.less6.view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ProjOOPJava.less6.controller.DeliveryController;
import ProjOOPJava.less6.service.DelivetyEnum;

import javax.swing.*;

public class DeliveryUI{
    protected JFrame frame;
    protected JButton createOrderButton, delivetyOrderButton;
    protected JTextField createOrderText;
    protected JTextArea delivetyOrderText;
    protected JComboBox<String> deliveryTransport;
    public DeliveryUI(){
        frame = new JFrame("Delivery Fabric");
        JLabel userLabel = new JLabel("Поля пользователя");
        userLabel.setBounds(200, 10, 150, 30);
        createOrderText = new JTextField();
        createOrderText.setBounds(10, 50, 250, 50);
        createOrderButton = new JButton("Создать заказ");
        createOrderButton.setBounds(270, 50, 200, 50);
        JLabel delayLabel = new JLabel("_________________________________________________________________");
        delayLabel.setBounds(10, 110, 500, 30);
        frame.add(userLabel);
        frame.add(createOrderText);
        frame.add(createOrderButton);
        frame.add(delayLabel);
        
        JLabel deliveryLabel = new JLabel("Поля доставщика");
        deliveryLabel.setBounds(200, 140, 150, 30);
        delivetyOrderText = new JTextArea();
        delivetyOrderText.setBounds(10, 180, 250, 150);
        deliveryTransport = new JComboBox<>(new String[]{"Велосипед","Электро самокат","Квадрокоптер","Пешком"});
        deliveryTransport.setBounds(270, 180, 200, 50);
        delivetyOrderButton = new JButton("Доставить заказ");
        delivetyOrderButton.setBounds(270, 240, 200, 50);
        frame.add(deliveryLabel);
        frame.add(deliveryTransport);
        frame.add(delivetyOrderText);
        frame.add(delivetyOrderButton);

        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        createOrderButton.addActionListener(new DeliveryUI.UserOrder());
        delivetyOrderButton.addActionListener(new DeliveryUI.DeliveryOrder());
        
    }
    public void setVisible(){
        frame.setVisible(true);
    }
    class UserOrder implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            delivetyOrderText.setText(createOrderText.getText());
        }
    }
    class DeliveryOrder implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(createOrderText.getText().equals("") || createOrderText.getText().equals("Доставка выполнена")){
                delivetyOrderText.setText("В данный момент заказов нет");
                createOrderText.setText("");
            }else{
                DeliveryController delivery = new DeliveryController();
                delivery.delivery(DelivetyEnum.values()[deliveryTransport.getSelectedIndex()]);
                delivetyOrderText.setText(createOrderText.getText() + "\n" + delivery.getTransport() + "\n" + delivery.receivingAnOrder() + "\n" 
                + delivery.deliveryOrder() + "\n" + delivery.deliveryComplite());
                createOrderText.setText(delivery.deliveryComplite());
            }
        }
        
    }
}

