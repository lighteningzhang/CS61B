ArraySet<T> o = (ArraySet<T>) other;
        if(other == null) return false;
        if(this.getClass()!=other.getClass()) return false;
        if(o.size()!=this.size()) return false;
        for(T i : o){
            if(!this.contains(i)){
                return false;
            }
        }