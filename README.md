# Parallel Sorting with Thread Pools

<p>In this exercise you should parallelize the Mergesort sorting algorithm learned from the lecture.
For that, a <a rel="noopener noreferrer" href="https://docs.oracle.com/en/java/javase/12/docs/api/java.base/java/util/concurrent/ForkJoinPool.html">ForkJoinPool</a> from the standard library can be used.</p>
<h4 id="benchmark">Benchmark</h4>
<p>The <code>BenchmarkApproaches</code> class is already included in the template. The execution of the contained <code>main</code> method performs a benchmark of the three mergesort implementations.
If you have not yet implemented all versions, you can simply comment out the relevant benchmark.</p>
<p>The benchmarks do not test the implementation for correctness, but only measure the time that is required for execution!</p>
<p>For the benchmarks you should import the project as a Maven project, for this you have to do the following: <br>
Eclipse: Simply import the project as a Maven project <br>
Maybe do that: <a rel="noopener noreferrer" href="https://chat.tum.de/group/NQtiHN7BfDiWMwze8?msg=wyDH3aDKtsPNv2TkB">https://chat.tum.de/group/NQtiHN7BfDiWMwze8?msg=wyDH3aDKtsPNv2TkB</a> <br>
IntelliJ: After the first import, do this: Shift + Ctrl + A -&gt; Reimport all Maven Projects <br></p>
<p>If that doesn't work, you can ask your tutor during the exercise.</p>
<h4 id="classes">Classes</h4>
<p>You should implement two different variants of the algorithm and then compare them with a sequential variant.
The sequential variant is already implemented in the template, as are the methods of the classes <code>ParallelMergeSort</code> and<code>BetterParallelMergeSort</code>.</p>
<p>In order to be able to use a <code>ForkJoinPool</code>, your classes have to implement the abstract class<code>RecursiveAction</code> and the abstract method <code>compute</code>. Within the <code>compute</code> class you can use<code>invoke</code> and <code>invokeAll</code> to start the execution of further<code>RecursiveActions</code>, which are then executed by the <code>ForkJoinPool</code>.</p>
<ol>
<li><div class="pe-task-0 d-flex"><jhi-programming-exercise-instructions-task-status _nghost-wxq-c178=""><div _ngcontent-wxq-c178="" class="guided-tour">
    <!---->
    <!---->
    <fa-icon _ngcontent-wxq-c178="" size="lg" class="ng-fa-icon test-icon text-secondary ng-star-inserted"><svg role="img" aria-hidden="true" focusable="false" data-prefix="fas" data-icon="circle-question" class="svg-inline--fa fa-circle-question fa-lg" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512"><path fill="currentColor" d="M256 0C114.6 0 0 114.6 0 256s114.6 256 256 256s256-114.6 256-256S397.4 0 256 0zM256 400c-18 0-32-14-32-32s13.1-32 32-32c17.1 0 32 14 32 32S273.1 400 256 400zM325.1 258L280 286V288c0 13-11 24-24 24S232 301 232 288V272c0-8 4-16 12-21l57-34C308 213 312 206 312 198C312 186 301.1 176 289.1 176h-51.1C225.1 176 216 186 216 198c0 13-11 24-24 24s-24-11-24-24C168 159 199 128 237.1 128h51.1C329 128 360 159 360 198C360 222 347 245 325.1 258z"></path></svg></fa-icon><!---->
    <span _ngcontent-wxq-c178="" class="task-name ng-star-inserted">ParallelMergeSort</span><!---->
    
</div>
</jhi-programming-exercise-instructions-task-status></div>
<p>Complete the class <code>ParallelMergeSort</code>. Every time the array is split into two sub-arrays, the class should submit two tasks to the <code>ForkJoinPool</code>.
As soon as your implementation is finished and the public correctness test is successful, test the performance and compare it with the sequential solution!</p></li>
<li><div class="pe-task-1 d-flex"><jhi-programming-exercise-instructions-task-status _nghost-wxq-c178=""><div _ngcontent-wxq-c178="" class="guided-tour">
    <!---->
    <!---->
    <fa-icon _ngcontent-wxq-c178="" size="lg" class="ng-fa-icon test-icon text-secondary ng-star-inserted"><svg role="img" aria-hidden="true" focusable="false" data-prefix="fas" data-icon="circle-question" class="svg-inline--fa fa-circle-question fa-lg" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512"><path fill="currentColor" d="M256 0C114.6 0 0 114.6 0 256s114.6 256 256 256s256-114.6 256-256S397.4 0 256 0zM256 400c-18 0-32-14-32-32s13.1-32 32-32c17.1 0 32 14 32 32S273.1 400 256 400zM325.1 258L280 286V288c0 13-11 24-24 24S232 301 232 288V272c0-8 4-16 12-21l57-34C308 213 312 206 312 198C312 186 301.1 176 289.1 176h-51.1C225.1 176 216 186 216 198c0 13-11 24-24 24s-24-11-24-24C168 159 199 128 237.1 128h51.1C329 128 360 159 360 198C360 222 347 245 325.1 258z"></path></svg></fa-icon><!---->
    <span _ngcontent-wxq-c178="" class="task-name ng-star-inserted">BetterParallelMergeSort</span><!---->
    
</div>
</jhi-programming-exercise-instructions-task-status></div>
<p>You should have noticed that <code>ParallelMergeSort</code> is significantly slower than the sequential solution.
This is because we are creating new tasks for sorting very small arrays too, and this involves a lot of overhead.
A parallel mergesort implementation that is supposed to achieve better performance should therefore create fewer tasks during execution.
Complete the class <code>BetterParallelMergeSort</code>, which sorts arrays that are below a certain size sequentially.</p>
<p>You should then empirically determine the boundary between parallel and sequential execution.
Try different values ​​for this. Try to find a value that executes fastest for an array of 100,000 elements!</p>
<p>The values ​​can vary depending on the hardware, operating system and other factors. So there is no one-stop solution here!</p></li>
</ol></div>
</div><!---->
<!---->
</jhi-programming-exercise-instructions><!---->
