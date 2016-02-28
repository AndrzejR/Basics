def build_int_list_simple(n):
	i = 1
	list_of_ints = []
	while i <= n:
		list_of_ints.append(n)
		i+=1
	return list_of_ints

# when will it fail?
for x, y in [(pow(10,y),y) for y in range(1,100)]:
	try:
		print("Summing up for: 10^" + str(y))
		print(sum(build_int_list_simple(x)))
	except MemoryError as e:
		# memory errors do not always get caught correctly, such is life
		print("Failed on 10^" + str(y) + " with:")
		print(e)
		break

# 32bit python fails on 10^9
# 64bit works for 10^9, but on 10^10 wins over windows memory management and makes the system not responsive
