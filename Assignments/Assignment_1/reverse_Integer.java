class reverse_Integer {
    public int reverse(int x){

        int r = 0;
        while(x !=0)
        {
            int t = x%10;
            r = r*10+t;
            x = (x-t)/10;
            
            if(r%10!=t)
            {
                return 0;
            }
        }
        
        return r;
    }
}