package com.java.JavaRefresherIntermediate.Sessionn33;

public class TowerofHanoi {

	public static void main(String[] args) {
		
		int[][] ans = towerofHanoiTwoDArrays(5, 1, 2, 3);
		System.out.println("Disk\tSource\tDestination");
		System.out.print("[");
		for (int i = 0; i < ans.length; i++) {
			System.out.print("[");
			for (int j = 0; j < ans[i].length; j++) {
				System.out.print(ans[i][j]);
				if (j != ans[i].length - 1)
					System.out.print(" ");
			}
			System.out.print("]");
			if (i != ans.length - 1)
				System.out.println(",");
		}
		System.out.print("]");
		System.out.println("");
		
		towerofHanoi(5,1,2,3);

	}

	public static void towerofHanoi(int num, int source, int destination, int helper) {
		if (num == 0)
			return;
		if (num == 1) {
			System.out.println("Move disk " + num + " from " + source + " to " + destination);
			return;
		}
		towerofHanoi(num - 1, source, helper, destination);
		System.out.println("Move disk " + num + " from " + source + " to " + destination);
		towerofHanoi(num - 1,helper, destination, source);
	}

	public static int[][] towerofHanoiTwoDArrays(int num, int source, int helper, int destination) {
		if (num == 0)
			return new int[0][0];
		if (num == 1) {
			return new int[][] { { num, source, destination } };
		}
		int[][] ans1 = towerofHanoiTwoDArrays(num - 1, source, destination, helper);
		int[][] ans2 = towerofHanoiTwoDArrays(num - 1, helper, source, destination);
		int[][] ans = new int[ans1.length + ans2.length + 1][3];
		for (int i = 0; i < ans1.length; i++) {
			ans[i] = ans1[i];
		}
		ans[ans1.length] = new int[] { num, source, destination };
		for (int i = 0; i < ans2.length; i++) {
			ans[ans1.length + 1 + i] = ans2[i];
		}
		
		return ans;
	}
}
