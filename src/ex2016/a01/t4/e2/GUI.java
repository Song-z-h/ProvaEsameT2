package ex2016.a01.t4.e2;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.swing.*;

public class GUI {

	private DealWithFile f;

	public GUI(String fileName, int size) {
		JFrame jf = new JFrame();

		List<JButton> buttons = new ArrayList<>(size);
		f = new DealWithFileImpl(fileName);

		for (int i = 0; i < size; i++) {
			buttons.add(new JButton("1"));
		}
		buttons.stream().forEach(button -> button.addActionListener(e -> {
			final Optional<String> str = Optional.ofNullable(f.read());
			System.out.println(str);
			if(str.isPresent()) {
				buttons.stream().forEach(b -> b.setText(str.get()));
			}else {
				buttons.stream().forEach(b -> b.setEnabled(false));
			}
			
		}));

		JButton jbOK = new JButton("Reset");
		jbOK.addActionListener(e -> {
			f = new DealWithFileImpl(fileName);
			buttons.stream().forEach(b -> b.setEnabled(true));
		});
		JPanel jp = new JPanel();
		buttons.stream().forEach(b -> jp.add(b));
		jp.add(jbOK);
		jf.getContentPane().add(jp);
		jf.pack();
		jf.setVisible(true);
	}

}
