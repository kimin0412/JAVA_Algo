package H2139;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

class Solution {
	private static BufferedReader br;
	private static StringTokenizer st;

	private static UserSolution usersolution = new UserSolution();

	private static final int NAMELEN = 11;
	private static final int PATHLEN = 1001;

	private static final int CMD_MAKEDIR = 100;
	private static final int CMD_MAKELINK = 200;
	private static final int CMD_MAKESYSTEMFILE = 300;
	private static final int CMD_FINDDOWNLOADDIR = 400;

	private static char path1[] = new char[PATHLEN + 1];
	private static char path2[] = new char[PATHLEN + 1];
	private static char name[] = new char[NAMELEN + 1];

	private static int nextInt() throws IOException {
		if (st == null || !st.hasMoreTokens()) {
			st = new StringTokenizer(br.readLine(), " ");
		}
		return Integer.parseInt(st.nextToken());
	}

	private static void String2Char(String s, char[] b) {
		int n = s.length();
		for (int i = 0; i < n; ++i) {
			b[i] = s.charAt(i);
		}
		b[n] = '\0';
	}

	private static boolean strcmp(char s1[], char s2[]) {
		int p = 0;
		while (s1[p] != '\0' && s1[p] == s2[p]) {
			++p;
		}
		return s1[p] == s2[p];
	}

	private static int run(int Result) throws IOException {

		int N = nextInt();
		usersolution.init();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int cmd = Integer.parseInt(st.nextToken());

			switch (cmd) {
			case CMD_MAKEDIR:
				String2Char(st.nextToken(), path1);
				String2Char(st.nextToken(), name);
				usersolution.makeDir(path1, name);
				break;

			case CMD_MAKELINK:
				String2Char(st.nextToken(), path1);
				String2Char(st.nextToken(), path2);
				usersolution.makeLink(path1, path2);
				break;

			case CMD_MAKESYSTEMFILE:
				String2Char(st.nextToken(), path1);
				usersolution.makeSystemFile(path1);
				break;

			case CMD_FINDDOWNLOADDIR:
				path1 = new char[PATHLEN + 1];
				usersolution.findDownloadDir(path1);
				boolean isanswer = false;
				int ansnum = Integer.parseInt(st.nextToken());

				for (int ans = 0; ans < ansnum; ans++) {
					path2 = new char[PATHLEN + 1];
					st = new StringTokenizer(br.readLine(), " ");
					String2Char(st.nextToken(), path2);

					if (strcmp(path1, path2))
						isanswer = true;
				}
				if (!isanswer)
					Result = 0;

				break;
			}
		}
		return Result;
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new java.io.FileInputStream("res/H2139/sample_input.txt"));

		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");

		int T = nextInt();
		int Result = nextInt();

		for (int tc = 1; tc <= T; tc++) {
			System.out.println("#" + tc + " " + run(Result));
		}
		br.close();
	}
}
