package src;

public class DAG {

        private int vertices;
        private int edges;
        private int[][] connected;
        private int[] checked;

        private int[] coming_in;
        private int[] coming_out;

    public DAG(int vertices){
        if(vertices < 0){
            throw new IllegalArgumentException("There must be more than 0 vertices is the DAG");
        }
        else{
            this.vertices = vertices;
            this.edges = 0;
            connected = new int[vertices][vertices];
            checked = new int[vertices];
            coming_in = new int[vertices];
            coming_out = new int[vertices];
            for(int i = 0; i<vertices; i++){
                for(int j = 0; j<vertices; j++){
                    connected[i][j] = 0;
                }
            }
        }

    }

    public int edges(){
        return edges;
    }
    public int vertices(){
        return vertices;
    }

    public void addEdge(int x, int y){
        if(((x>0) && (x<=vertices)) && ((y>0) && (y<=vertices))){
            connected[x][y] = 1;
            edges++;
            coming_in[y]++;
            coming_out[x]++;
        }
        else{
            edges=edges;
        }
    }

    public int number_edges_out(int x){
        if(((x>0) && (x<=vertices))){
            return coming_out[x];
        }
        else{
            return -1;
        }
    }

    public int numbers_edges_in(int y){
        if(((y>0) && (y<=vertices))){
            return coming_in[y];
        }
        else{
            return -1;
        }
    }

    public int[] number_connections(int x){
        if((x>0) && (x<vertices)){
            int[] temp = new int[number_edges_out(x)];
            int counter = 0;
            for(int i=0; i<vertices; i++){
                if(connected[x][i] == 1){
                    temp[counter] = i;
                    counter++;
                }
            }
            return temp;
        }
        else{
            return null;
        }
    }

    public boolean cyclical(){
        boolean cyclical = false;
        int counter = 1;
        for(int i=0; i<vertices; i++){
            checked[counter] = i;
            for(int j=0; j<vertices; j++){
                for(int k=0; k<vertices; k++){
                    if(checked[k] == j && connected[i][j]==1){
                        cyclical = true;
                    }
                }
            }
            counter++;
        }
        return cyclical;
    }

    public int LCA(int x, int y){
        if(((x<0) && (x<vertices)) && ((y<0) &&(y<vertices))){
            cyclical();
            if((edges<0) && (!cyclical())){
                return findLCA(x,y);
            }
        }
        return -1;
    }

    public int findLCA(int x, int y){
        int[] xArray = new int[edges];
        int[] yArray = new int[edges];

        boolean[] xChecked = new boolean[vertices];
        boolean[] yChecked = new boolean[vertices];

        int xCount = 0;
        int yCount = 0;

        xArray[xCount] = x;
        yArray[yCount] = y;

        for(int i = 0; i<vertices; i++) {
            xChecked[i] = false;
            yChecked[i] = false;
        }
        for(int i = 0; i<vertices; i++){
            xChecked[x] = true;
            yChecked[y] = true;
            for(int j = 0; j<vertices; j++){
                if((connected[i][j] == 1) && (xChecked[i])){
                    xCount++;
                    xArray[xCount] = j;
                    xChecked[j] = true;
                }
                if((connected[i][j] == 1) && (yChecked[j])){
                    yCount++;
                    yArray[yCount] = j;
                    yChecked[j] = true;
                }
                if(yArray[yCount] == xArray[xCount]){
                    return yArray[yCount];
                }
            }
        }
        return -1;
    }
}
