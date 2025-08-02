class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
       
        if(nums1.size()>nums2.size())return findMedianSortedArrays(nums2,nums1);
        
        int l1=nums1.size(),l2=nums2.size();
        int tl=l1+l2;
        int low=0,high=l1-1;
        double leftx,rightx,lefty,righty;
        while(low-high<=1)
        {
            int partx=low+(high-low)/2;
            int party=(tl+1)/2-partx;
            
            double leftx= (partx==0)?INT_MIN:nums1[partx-1];
            double rightx= (partx==l1)?INT_MAX:nums1[partx];
            double lefty= (party==0)?INT_MIN:nums2[party-1];
            double righty=(party==l2)?INT_MAX:nums2[party];
            //cout<<leftx<<" "<<rightx<<" "<<lefty<<" "<<righty<<endl;
            if(leftx<=righty&&lefty<=rightx)
            { 
                // cout<<leftx<<" "<<rightx<<" "<<lefty<<" "<<righty<<endl;
                if(tl%2)return max(leftx,lefty);
                else return (max(leftx,lefty)+min(rightx,righty))/2;
            }
            else if(leftx>righty)
            {
                high=partx-1;
            }
            else
            {
                low=partx+1;
            }
        }
        
       
        return 0.0;
       
                     
    }
};