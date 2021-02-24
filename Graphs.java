public class Graphs
{
    int minDistance(int[] Distance, Boolean[] VisitedNodes, int NodeCount)
        {
            int Min_Distance = Integer.MAX_VALUE;
            int Min_Index = -1;

            for (int i = 0; i <= NodeCount - 1; i++)
            {
                if (!VisitedNodes[i] && Distance[i] < Min_Distance)
                {
                    Min_Distance = Distance[i];
                    Min_Index = i;
                }
            }
            return Min_Index;
        }

        public void PrintShortestPath(int[] Distance, int[] Parent, int NodeCount)
        {
            System.out.println();
            System.out.println("Shortest Path");
            System.out.println("NODE \t\t DISTANCE \t\t PARENT");
            for (int i = 0; i < NodeCount; i++)
            {
                System.out.println(i + " \t\t " + Distance[i] + " \t\t\t " + Parent[i]);
            }
        }
        public void PrintGraph(int[][] Graph, int NodeCount)
        {
            System.out.println("ORIGINAL GRAPH");
            System.out.println("SOURCE \t\t DESTINATION \t\t EDGE");
            for (int i = 0; i < NodeCount; i++)
            {
                for (int j = 0; j < NodeCount; j++)
                {
                    System.out.println(i + " \t\t " + j + " \t\t\t " + Graph[i][j]);
                }
            }
        }
        public void DijkstrasAlgorithm(int[][] Graph, int Source, int NodeCount)
        {
            int MinNode;
            int[] Distance = new int[NodeCount];
            Boolean[] VisitedNode = new Boolean[NodeCount];
            int[] Parent= new int[NodeCount];

            for (int i = 0; i < NodeCount; i++)
            {
                Distance[i] = Integer.MAX_VALUE;
                VisitedNode[i] = false;
                Parent[i] = -1;
            }

            Distance[Source] = 0;

            for (int i = 0; i < NodeCount - 1; i++)
            {
                MinNode = minDistance(Distance, VisitedNode, NodeCount);
                VisitedNode[MinNode] = true;
                for (int j = 0; j < NodeCount; j++)
                {
                    if (!VisitedNode[j] && Graph[MinNode][j] != 0 && Distance[MinNode] != Integer.MAX_VALUE && Distance[MinNode] + Graph[MinNode][j] < Distance[j])
                    {
                        Distance[j] = Distance[MinNode] + Graph[MinNode][j];
                        Parent[j] = MinNode;
                    }
                }
            }
            PrintShortestPath(Distance, Parent, NodeCount);
        }

        public static void main(String[] args)
        {
            int NodeCount = 10;
            int[][] Graph = { 
                                new int[] { 0, 4, 0, 0, 0, 8, 0, 0, 0, 0}, 
                                new int[] { 4, 0, 8, 0, 0, 11, 0, 0, 6, 0 }, 
                                new int[] { 0, 8, 0, 7, 0, 0, 10, 6, 2, 5 }, 
                                new int[] { 0, 0, 7, 0, 9, 0, 0, 14, 0, 3 }, 
                                new int[] { 0, 0, 0, 9, 0, 0, 0, 10, 0, 0 }, 
                                new int[] { 8, 11, 0, 0, 0, 0, 1, 0, 7, 0 }, 
                                new int[] { 0, 0, 10, 0, 0, 1, 0, 2, 6, 6 }, 
                                new int[] { 0, 0, 6, 14, 10, 0, 2, 0, 0, 7 },
                                new int[] { 0, 6, 2, 0, 0, 7, 6, 0, 0, 0 },
                                new int[] { 0, 0, 5, 3, 0, 0, 6, 7, 0, 0}
                            };
            Graphs t = new Graphs();
            t.PrintGraph(Graph, NodeCount);
            t.DijkstrasAlgorithm(Graph, 0, NodeCount);
        }
}