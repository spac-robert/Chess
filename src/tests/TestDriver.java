package tests;

public class TestDriver {
    private final TestPawn testPawn;
    private final TestBishop testBishop;
    private final TestKing testKing;
    private final TestKnight testKnight;
    private final TestQueen testQueen;
    private final TestRook testRook;
    private final TestPlayer testPlayer;
    private final TestLocation testLocation;
    private final TestSquare testSquare;
    private final TestTable testTable;

    public TestDriver() {
        this.testPawn = new TestPawn();
        this.testBishop = new TestBishop();
        this.testKing = new TestKing();
        this.testKnight = new TestKnight();
        this.testQueen = new TestQueen();
        this.testRook = new TestRook();
        this.testPlayer = new TestPlayer();
        this.testLocation = new TestLocation();
        this.testSquare = new TestSquare();
        this.testTable = new TestTable();
    }

    public void runTests() {
        testPawn.runTestPawn();
        testBishop.runTestBishop();
        testKing.runTestKing();
        testKnight.runTestKnight();
        testQueen.runTestQueen();
        testRook.runTestRook();
        testPlayer.runTestPlayer();
        testLocation.runTestLocation();
        testSquare.runTestSquare();
        testTable.runTestTable();
    }
}
