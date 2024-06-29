import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.*;

public class CreateQueryAndDeleteFiles extends JFrame {
	static String indent = "";
	static final String INDENT_STEP = "    ";
	static JTextArea show = new JTextArea("请在上方输入要什么地方创建文件夹A，路径分隔符用\\或/或File.separator");
	JButton createButton = new JButton("在当前位置下创建文件夹A");
	JButton readButton = new JButton("显示文件夹A的层次结构");
	JButton deleteButton = new JButton("删除整个文件夹A");
	JTextArea jTextArea = new JTextArea();
	JPanel jPanel = new JPanel();
	String path;

	public static void main(String[] args) {
		new CreateQueryAndDeleteFiles();
	}

	public CreateQueryAndDeleteFiles() {
		super("文件夹的创建、目录读取和删除");
		setVisible(true);
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		// 设置 JPanel 面板的布局管理器并将三个按钮添加进 JPanel 面板中
//		jPanel.setLayout(new );
		jPanel.add(createButton);
		jPanel.add(readButton);
		jPanel.add(deleteButton);

		// 将 JPanel 面板、JLabel、JTextArea添加进 JFrame中。
		add(show, BorderLayout.CENTER);
		add(jTextArea, BorderLayout.NORTH);
		add(jPanel, BorderLayout.SOUTH);

		jTextArea.setBackground(Color.lightGray);// 给JTextArea设置一个背景色
		show.setEnabled(false);// 设置JTextArea为不可编辑
		show.setDisabledTextColor(Color.black);// 设置JTextArea为不可编辑时的文本颜色

		// 为按钮注册事件监听器
		createButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				path = jTextArea.getText().toString();// 要写在actionPerformed()方法内部
				if (path == null || path.trim().isEmpty()) {
					show.setText("请在上方输入路径！");
				} else {
					createFolder(path);
				}
			}
		});
		readButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				show.setText("");
				readFolder(path + File.separator + "A");
			}
		});
		deleteButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				deleteFolder(path+File.separator+"A");
				show.setText("删除成功！");
			}
		});
	}

	/**
	 * @MethodName: createFolder
	 * @Description: 在参数路径下创建A文件夹及其子文件夹/文件
	 */
	public static void createFolder(String path) {
		// 创建A文件夹
		String path_A = path + File.separator + "A";// A文件夹路径
		File file = new File(path_A);
		file.mkdir();
		// A文件夹
		File a_1 = new File(path_A + File.separator + "t_a1.txt");
		try {
			a_1.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		File a_2 = new File(path_A + File.separator + "t_a2.txt");
		try {
			a_2.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 创建B文件夹
		String pb = path_A + File.separator + "B";
		File a_b = new File(pb);
		a_b.mkdir();
		// B文件夹
		File b_1 = new File(pb + File.separator + "t_b1.txt");
		try {
			b_1.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		File b_2 = new File(pb + File.separator + "t_b2.txt");
		try {
			b_2.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		File b_3 = new File(pb + File.separator + "B_B1");
		b_3.mkdir();
		File b_4 = new File(pb + File.separator + "B_B2");
		b_4.mkdir();
		// 创建C文件夹
		String pc = pb + File.separator + "C";
		File b_c = new File(pc);
		b_c.mkdir();
		// C文件夹
		File c_1 = new File(pc + File.separator + "t_c1.txt");
		try {
			c_1.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		File c_2 = new File(pc + File.separator + "t_c2.txt");
		try {
			c_2.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		File c_3 = new File(pc + File.separator + "t_c3.txt");
		try {
			c_3.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (file.exists()) {
			show.setText("文件夹A创建成功！");
		} else {
			show.setText("文件夹A创建失败！");
		}
		File c_4 = new File(pc + File.separator + "C_C1");
		c_4.mkdir();
	}

	/**
	 * @MethodName: readFolder
	 * @Description: 读取参数路径下创建的A文件夹并显示层级结构，如果没有这样一个文件夹或不是文件夹，则输出"尚未创建文件夹或不是一个文件夹"。
	 */
	public static void readFolder(String path) {
//		String path_A = path + File.separator + "A";// A文件夹路径
		File file = new File(path);
		File[] files = file.listFiles();
		if (files == null) {
			System.out.println(path + "：尚未创建文件夹或不是一个文件夹");
		} else {
			for (File file2 : files) {
				if (file2.isDirectory()) {
					if ((file2.listFiles()).length == 0) {
//						System.out.println(indent + file2.getName() + "空文件夹");
						show.append(indent + file2.getName() + "空文件夹\n");
					} else {
//						System.out.println(indent + file2.getName() + "：文件夹");
						show.append(indent + file2.getName() + "：文件夹\n");
						indent += INDENT_STEP;
						readFolder(file2.getPath());
						indent = indent.substring(0, indent.length() - INDENT_STEP.length());
					}
				} else {
//					System.out.println(indent + file2.getName() + "：文  件");
					show.append(indent + file2.getName() + "：文  件\n");
				}
			}
		}
	}

	/**
	 * @MethodName: deleteFolder
	 * @Description: 删除参数路径下创建的整个A文件夹
	 */
	public static void deleteFolder(String path) {
//		String path_A = path + File.separator + "A";// A文件夹路径
		File file = new File(path);
		if (file.exists()) {
			File[] files = file.listFiles();
			if (files != null) {
				for (File file2 : files) {
					if (file2.isDirectory()) {
						deleteFolder(file2.getPath());
					} else {
						file2.delete();
					}
				}
			}
			file.delete();
		} else {
			System.out.println("文件夹不存在，删除失败！");
		}
	}

}
