/*
  Copyright (c) 2009 Philipp Carpus  <random234@gmx.net>
  Copyright (c) 2009 Center for Bioinformatics, University of Hamburg

  Permission to use, copy, modify, and distribute this software for any
  purpose with or without fee is hereby granted, provided that the above
  copyright notice and this permission notice appear in all copies.

  THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
  WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
  MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR
  ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
  WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
  ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF
  OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
*/


package annotationsketch;

import gtnative.GT;
import com.sun.jna.Pointer;

public abstract class Canvas {
  protected Pointer canvas_ptr;
  private boolean disposed;

  protected void set_disposed(boolean bool) {
    disposed = bool;
  }
  
  public Pointer to_ptr() {
    return canvas_ptr;
  }

  public synchronized void dispose() {
    if(!disposed){
      GT.INSTANCE.gt_canvas_delete(canvas_ptr);
      disposed = true;
    }
  }
  
  protected void finalize() {
    if(!disposed){
      dispose();
    }
  }
}
