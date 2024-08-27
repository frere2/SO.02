package view;

import javax.swing.JOptionPane;

import controller.KillController;

public class Main {
	public static void main(String[] args) {
		int opt = Integer.parseInt(JOptionPane.showInputDialog("1 - Kill Nome\n2 - Kill Pid\n3 - Finalizar"));
		KillController killController = new KillController();
		switch (opt) {
			case 1: killController.killNome("notepad"); break;
			case 2: killController.killPid(542); break;
			case 3: break;
		}
	}
}
