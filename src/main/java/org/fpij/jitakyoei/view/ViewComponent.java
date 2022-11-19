package main.java.org.fpij.jitakyoei.view;

import javax.swing.JPanel;

import main.java.org.fpij.jitakyoei.facade.AppFacade;

public interface ViewComponent {
	public JPanel getGui();
	public void registerFacade(AppFacade fac);
}
