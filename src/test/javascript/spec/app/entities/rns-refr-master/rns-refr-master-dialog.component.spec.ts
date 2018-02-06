/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async, inject, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable } from 'rxjs/Observable';
import { JhiEventManager } from 'ng-jhipster';

import { JhipsterSampleApplicationTestModule } from '../../../test.module';
import { RNS_REFR_MASTERDialogComponent } from '../../../../../../main/webapp/app/entities/rns-refr-master/rns-refr-master-dialog.component';
import { RNS_REFR_MASTERService } from '../../../../../../main/webapp/app/entities/rns-refr-master/rns-refr-master.service';
import { RNS_REFR_MASTER } from '../../../../../../main/webapp/app/entities/rns-refr-master/rns-refr-master.model';
import { RNSREFRDETAILSService } from '../../../../../../main/webapp/app/entities/rnsrefrdetails';
import { RNSCATGMASTERService } from '../../../../../../main/webapp/app/entities/rnscatgmaster';

describe('Component Tests', () => {

    describe('RNS_REFR_MASTER Management Dialog Component', () => {
        let comp: RNS_REFR_MASTERDialogComponent;
        let fixture: ComponentFixture<RNS_REFR_MASTERDialogComponent>;
        let service: RNS_REFR_MASTERService;
        let mockEventManager: any;
        let mockActiveModal: any;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [JhipsterSampleApplicationTestModule],
                declarations: [RNS_REFR_MASTERDialogComponent],
                providers: [
                    RNSREFRDETAILSService,
                    RNSCATGMASTERService,
                    RNS_REFR_MASTERService
                ]
            })
            .overrideTemplate(RNS_REFR_MASTERDialogComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(RNS_REFR_MASTERDialogComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(RNS_REFR_MASTERService);
            mockEventManager = fixture.debugElement.injector.get(JhiEventManager);
            mockActiveModal = fixture.debugElement.injector.get(NgbActiveModal);
        });

        describe('save', () => {
            it('Should call update service on save for existing entity',
                inject([],
                    fakeAsync(() => {
                        // GIVEN
                        const entity = new RNS_REFR_MASTER(123);
                        spyOn(service, 'update').and.returnValue(Observable.of(new HttpResponse({body: entity})));
                        comp.rNS_REFR_MASTER = entity;
                        // WHEN
                        comp.save();
                        tick(); // simulate async

                        // THEN
                        expect(service.update).toHaveBeenCalledWith(entity);
                        expect(comp.isSaving).toEqual(false);
                        expect(mockEventManager.broadcastSpy).toHaveBeenCalledWith({ name: 'rNS_REFR_MASTERListModification', content: 'OK'});
                        expect(mockActiveModal.dismissSpy).toHaveBeenCalled();
                    })
                )
            );

            it('Should call create service on save for new entity',
                inject([],
                    fakeAsync(() => {
                        // GIVEN
                        const entity = new RNS_REFR_MASTER();
                        spyOn(service, 'create').and.returnValue(Observable.of(new HttpResponse({body: entity})));
                        comp.rNS_REFR_MASTER = entity;
                        // WHEN
                        comp.save();
                        tick(); // simulate async

                        // THEN
                        expect(service.create).toHaveBeenCalledWith(entity);
                        expect(comp.isSaving).toEqual(false);
                        expect(mockEventManager.broadcastSpy).toHaveBeenCalledWith({ name: 'rNS_REFR_MASTERListModification', content: 'OK'});
                        expect(mockActiveModal.dismissSpy).toHaveBeenCalled();
                    })
                )
            );
        });
    });

});
