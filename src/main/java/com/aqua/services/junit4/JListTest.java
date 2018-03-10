package com.aqua.services.junit4;

import junit.framework.SystemTestCase4;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class JListTest extends SystemTestCase4 {
    public static void main(String args[]) {
        String labels[] = {"Port 0", "Port 1", "Port 2", "Port 3", "Port 4", "Port 5", "Port 6", "Enable  All", "Disable All"};
        JFrame frame = new JFrame("Selecting Port to open");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JList jlist = new JList(labels);
        JScrollPane scrollPane1 = new JScrollPane(jlist);
        frame.add(scrollPane1, BorderLayout.CENTER);

        MouseListener mouseListener = new MouseAdapter() {
            public void mouseClicked(MouseEvent mouseEvent) {
                JList theList = (JList) mouseEvent.getSource();
                if (mouseEvent.getClickCount() == 1) {
                    int index = theList.locationToIndex(mouseEvent.getPoint());
                    if (index >= 0) {
                        Object o = theList.getModel().getElementAt(index);

                        switch (index) {

                            case 0:
                                report.report("Port selected: 0");
                                break;
                            case 1:
                                System.out.println("Port selected: 1");
                                break;
                            case 2:
                                System.out.println("Port selected: 2");
                                break;
                            case 3:
                                System.out.println("Port selected: 3");
                                break;
                            case 4:
                                System.out.println("Port selected: 4");
                                break;
                            case 5:
                                System.out.println("Port selected: 5");
                                break;
                            case 6:
                                System.out.println("Port selected: 6");
                                break;
                            case 7:
                                System.out.println("Enable all ports");
                                break;
                            case 8:
                                System.out.println("Disable all ports");
                                break;
                            default:
                                throw new IllegalArgumentException("Invalid port selection");
                        }
                    }
                }
            }
        };

        jlist.addMouseListener(mouseListener);
        frame.setSize(350,200);
        frame.setVisible(true);
        }
    }