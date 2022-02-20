public class FirstImpl implements FirstRmi {

    @Override
    public int doCal(int x, int y) throws Exception {
        return x+y;
    }
}
