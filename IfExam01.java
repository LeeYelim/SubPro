class IfExam01 {
	public static void main(String[] args) {
	
		int i = (int)(Math.random()*10)+1;

		// if��
		if(i % 2 == 0) { 
			System.out.println(i + "��/�� ¦���Դϴ�."); // 2�� ���(¦��)
		} else {
			System.out.println(i + "��/�� Ȧ���Դϴ�.");
		} 

		// ���׿�����
		String result = (i%2 == 0) ? "¦��" : "Ȧ��"; 
		System.out.println(i + "��/�� " + result);
	}
}