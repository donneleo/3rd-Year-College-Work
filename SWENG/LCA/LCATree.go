package main

import "fmt"

type Node struct{
	val int
	left *Node
	right *Node
}

func LowestCommonAncestor(root *Node, val1 int, val2 int) int{
	if root == nil{
		return -1
	}

	if val1 > root.val && val2 > root.val{
		return LowestCommonAncestor(root.right, val1, val2)
	}

	if val1 < root.val && val2 < root.val{
		return LowestCommonAncestor(root.left, val1, val2)
	}

	return root.val
}

func main(){

	root := Node{100, nil, nil}
	root.left = &Node{50, nil, nil}
	root.right = &Node{150, nil, nil}
	root.left.left = &Node{20, nil, nil}
	root.left.left.left = &Node{10, nil, nil}
	root.left.left.right = &Node{30, nil, nil}
	root.left.right = &Node{80, nil, nil}
	root.right.left = &Node{110, nil, nil}
	root.right.right = &Node{200, nil, nil}

	var result = LowestCommonAncestor(&root, 10, 80)
	fmt.Println("LAC is", result)

	var result2 = LowestCommonAncestor(&root, 30, 200)
	fmt.Println("LAC is", result2)

	var result3 = LowestCommonAncestor(&root, 10, 30)
	fmt.Println("LCA is", result3)

}

