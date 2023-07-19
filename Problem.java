public class Problem {
    public int[][] initstate = new int[3][3];
    public int[][] goalstate = {{1, 2, 3}, 
                                {4, 5, 6}, 
                                {7, 8, 0}};
    public int[][] trivial = {{1, 2, 3}, 
                              {4, 5, 6}, 
                              {7, 8, 0}};
    public int[][] veryeasy = {{1, 2, 3}, 
                               {4, 5, 6}, 
                               {7, 0, 8}};
    public int[][] easy = {{1, 2, 0}, 
                           {4, 5, 3}, 
                           {7, 8, 6}};
    public int[][] doable = {{0, 1, 2}, 
                             {4, 5, 3}, 
                             {7, 8, 6}};
    public int[][] ohboy = {{8, 7, 1}, 
                            {6, 0, 2}, 
                            {5, 4, 3}};
    public int[][] impossible = {{1, 2, 3}, 
                                 {4, 5, 6}, 
                                 {8, 7, 0}};

    public Problem(int[][] initstate, int choice) {
        switch(choice) {
            case 1:
                this.initstate = trivial;
                break;
            case 2:
                this.initstate = veryeasy;
                break;
            case 3:
                this.initstate = easy;
                break;
            case 4:
                this.initstate = doable;
                break;
            case 5:
                this.initstate = ohboy;
                break;
            case 6:
                this.initstate = impossible;
                break;
            default:
                this.initstate = initstate;
                break;
        }
    }
    
    
    public int[][] up(int[][] state) {
        int[][] tempstate = new int[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tempstate[i][j] = state[i][j];
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tempstate[i][j] == 0 && i > 0) {
                    int temp = tempstate[i][j];
                    tempstate[i][j] = tempstate[i - 1][j];
                    tempstate[i - 1][j] = temp;
                    return tempstate;
                }
            }
        }
        return tempstate;
    }

    public int[][] down(int[][] state) {
        int[][] tempstate = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tempstate[i][j] = state[i][j];
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tempstate[i][j] == 0 && i < 2) {
                    int temp = tempstate[i][j];
                    tempstate[i][j] = tempstate[i + 1][j];
                    tempstate[i + 1][j] = temp;
                    return tempstate;
                }
            }
        }
        return tempstate;
    }

    public int[][] left(int[][] state) {
        int[][] tempstate = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tempstate[i][j] = state[i][j];
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tempstate[i][j] == 0 && j > 0) {
                    int temp = tempstate[i][j];
                    tempstate[i][j] = tempstate[i][j - 1];
                    tempstate[i][j - 1] = temp;
                    return tempstate;
                }
            }
        }
        return tempstate;
    }

    public int[][] right(int[][] state) {
        int[][] tempstate = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tempstate[i][j] = state[i][j];
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {                
                if (tempstate[i][j] == 0 && j < 2) {
                    int temp = tempstate[i][j];
                    tempstate[i][j] = tempstate[i][j + 1];
                    tempstate[i][j + 1] = temp;
                    return tempstate;
                }
            }
        }
        return tempstate;
    }
}
