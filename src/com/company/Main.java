package com.company;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[]args) {
        SingleLinkedList<Pegawai> linkedList = new SingleLinkedList<>("Pegawai");
        linkedList.insertAtFront(new Pegawai("123", "Rafi", "Manager"));
        linkedList.insertAtFront(new Pegawai("324", "Resa", "Marketing"));

        Scanner input = new Scanner(System.in);
        boolean looping= true;

        while(looping) {
            System.out.println("Pilihlah menu: ");
            System.out.println("1. Input Data ");
            System.out.println("2. Hapus Data ");
            System.out.println("3. Cetak List Pegawai ");
            System.out.println("4. Keluar ");
            int number = input.nextInt();

            switch(number) {
                case 1:
                    System.out.println("Masukkan data ");
                    System.out.println("Tuliskan nip, nama, dan divisi pegawai ");
                String nip = input.next();
                String nama = input.next();
                String divisi = input.next();

                System.out.println("Tambahkan data di awal list (y/n)");

                if (input.next().equals("y")) {
                    linkedList.insertAtFront(new Pegawai(nip, nama, divisi));
                } else {
                    linkedList.insertAtBack(new Pegawai(nip, nama, divisi));
                }
                break;
                case 2:
                    System.out.println("Hapus data di awal list (y/n)");
                    if (input.next().equals("y")) {
                        linkedList.removeFromFront();
                    } else  {
                        linkedList.removeFromBack();
                    }
                    break;
                case 3:
                    linkedList.print();
                break;
                default:
                    looping = false;
                    break;
            }
        }

    }

}
