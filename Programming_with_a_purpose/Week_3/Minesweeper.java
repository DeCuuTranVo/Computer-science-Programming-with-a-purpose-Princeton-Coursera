package Programming_with_a_purpose.Week_3;

public class Minesweeper {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        int k = Integer.parseInt(args[2]);

        String[][] mine_matrix = new String[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mine_matrix[i][j] = "0";
            }
        }

        for (int t = 0; t < k; t++) {
            
            int rand_m = (int) (Math.random() * m);
            int rand_n = (int) (Math.random() * n);

            if (mine_matrix[rand_m][rand_n] == "*") {
                t = t-1;
            } else {
                mine_matrix[rand_m][rand_n] = "*";
            }            
        }
        
        if ((m == 1 ) && (n==1)) {
            
        }


        if ((m == 1) && (n !=1 )) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int count = 0;
                    if (mine_matrix[i][j] == "*") {
                        continue;
                    } else {
                        if ((i==0) && (j==0)) {
                            if (mine_matrix[i][j+1] == "*") {
                                count++;
                            }
                        } else if ((i==0) && (j==n-1)) {
                            if (mine_matrix[i][j-1] == "*") {
                                count++;
                            }
                        } else if ((i==0) && (j > 0) && (j <n-1)) {
                            if (mine_matrix[i][j-1] == "*") {
                                count++;
                            }

                            if (mine_matrix[i][j+1] == "*") {
                                count++;
                            }

                        }

                    }
                    mine_matrix[i][j] = Integer.toString(count);
                    
                }
            }
        }

        if ((m != 1) && (n == 1 )) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int count = 0;
                    if (mine_matrix[i][j] == "*") {
                        continue;
                    } else {
                        if ((i==0) && (j==0)) {
                            if (mine_matrix[i+1][j] == "*") {
                                count++;
                            }
                        } else if ((i==m-1) && (j==0)) {
                            if (mine_matrix[i-1][j] == "*") {
                                count++;
                            }
                        } else if ((i > 0) && (i < m-1) && (j == 0)) {
                            if (mine_matrix[i-1][j] == "*") {
                                count++;
                            }

                            if (mine_matrix[i+1][j] == "*") {
                                count++;
                            }

                        }

                    }
                    mine_matrix[i][j] = Integer.toString(count);
                    
                }
            }
        }

        if ((m !=1 ) && (n !=1 )) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int count = 0;
                    if (mine_matrix[i][j] == "*") {
                        continue;
                    } else {
                        if ((i == 0)&&(j==0)) {
                            if (mine_matrix[i+1][j] == "*") {
                                count++;
                            }

                            if (mine_matrix[i][j+1] == "*") {
                                count++;
                            }

                            if (mine_matrix[i+1][j+1] == "*") {
                                count++;
                            }
                        } else if ((i == m-1)&&(j==0)) {
                            if (mine_matrix[i-1][j] == "*") {
                                count++;
                            }

                            if (mine_matrix[i-1][j+1] == "*") {
                                count++;
                            }

                            if (mine_matrix[i][j+1] == "*") {
                                count++;
                            }
                        } else if ((i == 0)&&(j==n-1)) {
                            if (mine_matrix[i][j-1] == "*") {
                                count++;
                            }

                            if (mine_matrix[i+1][j-1] == "*") {
                                count++;
                            }

                            if (mine_matrix[i+1][j] == "*") {
                                count++;
                            }
                        } else if ((i == m-1)&&(j==n-1)) {
                            if (mine_matrix[i][j-1] == "*") {
                                count++;
                            }

                            if (mine_matrix[i-1][j-1] == "*") {
                                count++;
                            }

                            if (mine_matrix[i-1][j] == "*") {
                                count++;
                            }
                        } else if ((i == 0)&&((j>0) && (j<n-1))) {
                            if (mine_matrix[i][j-1] == "*") {
                                count++;
                            }

                            if (mine_matrix[i+1][j-1] == "*") {
                                count++;
                            }

                            if (mine_matrix[i+1][j] == "*") {
                                count++;
                            }

                            if (mine_matrix[i+1][j+1] == "*") {
                                count++;
                            }

                            if (mine_matrix[i][j+1] == "*") {
                                count++;
                            }
                        } else if ((i == m-1 )&&((j>0) && (j<n-1))) {
                            if (mine_matrix[i][j-1] == "*") {
                                count++;
                            }

                            if (mine_matrix[i-1][j-1] == "*") {
                                count++;
                            }

                            if (mine_matrix[i-1][j] == "*") {
                                count++;
                            }

                            if (mine_matrix[i-1][j+1] == "*") {
                                count++;
                            }

                            if (mine_matrix[i][j+1] == "*") {
                                count++;
                            }
                        } else if (((i> 0)&&(i<m-1))&&(j == 0)) {
                            if (mine_matrix[i-1][j] == "*") {
                                count++;
                            }

                            if (mine_matrix[i-1][j+1] == "*") {
                                count++;
                            }

                            if (mine_matrix[i][j+1] == "*") {
                                count++;
                            }

                            if (mine_matrix[i+1][j+1] == "*") {
                                count++;
                            }

                            if (mine_matrix[i+1][j] == "*") {
                                count++;
                            }
                        } else if (((i> 0)&&(i<m-1))&&(j == n-1)) {
                            if (mine_matrix[i-1][j] == "*") {
                                count++;
                            }

                            if (mine_matrix[i-1][j-1] == "*") {
                                count++;
                            }

                            if (mine_matrix[i][j-1] == "*") {
                                count++;
                            }

                            if (mine_matrix[i+1][j-1] == "*") {
                                count++;
                            }

                            if (mine_matrix[i+1][j] == "*") {
                                count++;
                            }
                        } else if (((i> 0)&&(i<m-1))&&((j >0)&&(j < n-1))) {
                            if (mine_matrix[i-1][j] == "*") {
                                count++;
                            }

                            if (mine_matrix[i-1][j-1] == "*") {
                                count++;
                            }

                            if (mine_matrix[i-1][j+1] == "*") {
                                count++;
                            }

                            if (mine_matrix[i][j-1] == "*") {
                                count++;
                            }

                            if (mine_matrix[i][j+1] == "*") {
                                count++;
                            } 
                            
                            if (mine_matrix[i+1][j] == "*") {
                                count++;
                            }

                            if (mine_matrix[i+1][j-1] == "*") {
                                count++;
                            }

                            if (mine_matrix[i+1][j+1] == "*") {
                                count++;
                            }
                        }
                        mine_matrix[i][j] = Integer.toString(count);
                    }    
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(mine_matrix[i][j] + "  ");
                
            }
            System.out.println();
        }

    }
    
}
