package cn.com.wudskq.leetcode;

/**
 * @author chenfangchao
 * @version 1.0.0
 * @ClassName removeElement.java
 * @Description TODO leetcode 27.移除元素
 * @createTime 2022年03月14日 15:10:00
 * @INFO TODO 给你一个数组 nums和一个值 val，你需要原地移除所有数值等于val的元素并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RemoveElement {

   static int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
   static int val = 2;



    public static void main(String[] args) {
        RemoveElement removeElement = new RemoveElement();
        int i = removeElement.removeElement(nums, val);
        System.out.println(i);
    }


    /**
     * 设置左右指针进行运算
     * TODO:核心思想设置左右指针,右指针用于判断是否vlaue与数组中值是否相等
     * 若不相等,则使用左指针重新覆盖该数组
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if(val != nums[right]){
                nums[left] = nums[right];
                left++;
            }
        }
        return  left;
    }
}
