package com.example.mongodbpoc.binarysearch;

public class BinarySeachExample {
    public static int binarySearch(int arr[], int item) {

        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == item) {
                return mid;
            } else if (item < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static int findSmallestMissingNum(int arr[]) {

        int low = 0, high = arr.length - 1;
        while (true) {
            if (low > high) {
                return low;
            }
            int mid = (low + high) / 2;
            if (arr[mid] == mid) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

    }

    public static int getCeil(int[] A, int x) {

        int left = 0, right = A.length - 1;
        int ceil = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (A[mid] == x) {
                return A[mid];
            } else if (x < A[mid]) {
                ceil = A[mid];
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ceil;
    }

    public static int searchItemInNearlSortedArray(int A[], int X) {
        int low = 0;
        int high = A.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (A[mid] == X) {
                return mid;
            } else if (mid - 1 >= low && A[mid - 1] == X) {
                return mid - 1;
            } else if (mid + 1 <= high && A[mid + 1] == X)
                return mid + 1;
            else if (X < A[mid]) {
                high = mid - 2;
            } else {
                low = mid + 2;
            }
        }
        return -1;
    }

    public static int getFloor(int[] A, int x) {

        int left = 0, right = A.length - 1;
        int floor = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (A[mid] == x) {
                return A[mid];
            } else if (x < A[mid]) {
                right = mid - 1;
            } else {
                floor = A[mid];
                left = mid + 1;
            }
        }

        return floor;
    }

    public static int findItemInRotatedArray(int A[], int x) {
        int low = 0;
        int high = A.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;

            if (x == A[mid]) {
                return mid;
            }
            if (A[mid] <= A[high]) {
                if (x > A[mid] && x <= A[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else {
                if (x >= A[low] && x < A[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }

        return -1;
    }

    public static int findFirstOccurance(int A[], int item) {
        int low = 0;
        int high = A.length - 1;
        int result = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (A[mid] == item) {
                result = mid;
                high = mid - 1;
            } else if (item < A[mid]) {
                high = mid - 1;
            } else if (item > A[mid]) {
                low = mid + 1;
            }
        }
        return result;
    }

    public static int findLastOccurance(int A[], int item) {
        int low = 0;
        int high = A.length - 1;
        int result = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (A[mid] == item) {
                result = mid;
                low = mid + 1;
            } else if (item < A[mid]) {
                high = mid - 1;
            } else if (item > A[mid]) {
                low = mid + 1;
            }
        }
        return result;
    }

    public static int searchElementInRoated(int A[], int X) {
        int minElementIndex = numOfTimesRoated(A);
        int left = binarySearch(A, 0, minElementIndex - 1, X);
        int right = binarySearch(A, minElementIndex, A.length - 1, X);
        if (left != -1)
            return left;
        else if (right != -1) {
            return right;
        } else {
            return -1;
        }

    }

    public static int numOfTimesRoated(int A[]) {

        int start = 0;
        int end = A.length;
        int N = end;
        while (start < end) {

            int mid = start + (end - start) / 2;
            int next = (mid + 1) % N;
            int prev = (mid + N - 1) % N;
            if (A[mid] <= A[next] && A[mid] <= A[prev]) {
                return mid;
            } else if (A[start] <= A[mid]) {
                start = mid + 1;
            } else if (A[mid] <= A[end]) {
                end = mid - 1;
            }
        }
        return -1;
    }

    public static int findRotationCount(int arr[]) {

        int low = 0, high = arr.length - 1, n = arr.length;
        while (low <= high) {
            if (arr[low] <= arr[high]) {
                return low;
            }
            int mid = (low + high) / 2;
            int next = (mid + 1) % n;
            int prev = (mid + n - 1) % n;
            if (arr[prev] >= arr[mid] && arr[mid] <= arr[next]) {
                return mid;
            } else if (arr[mid] <= arr[high]) {
                high = mid - 1;
            } else if (arr[mid] >= arr[low]) {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static int binarySearch(int arr[], int low, int high, int item) {

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == item) {
                return mid;
            } else if (item < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = {11, 12, 15, 18, 2, 5, 6, 8};

        System.out.println(searchElementInRoated(arr, 6));

    }
}
